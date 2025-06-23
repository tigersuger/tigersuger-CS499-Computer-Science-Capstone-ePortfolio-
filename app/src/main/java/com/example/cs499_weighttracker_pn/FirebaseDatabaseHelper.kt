package com.example.cs499_weighttracker_pn

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

// Data class for serialization
data class WeightEntry(val date: String = "", val weight: Double = 0.0)

class FirebaseDatabaseHelper {

    private val dbRef = Firebase.database("https://weighttrackerapp-phongnguyen-default-rtdb.firebaseio.com").reference
    private val weightsRef = dbRef.child("dailyWeights")
    private val goalRef    = dbRef.child("goalWeight")
    private var weightListener: ValueEventListener? = null // To hold our listener

    /** Insert a daily weight entry under /dailyWeights */
    fun insertDailyWeight(
        date: String,
        weight: Double,
        onComplete: () -> Unit
    ) {

        Log.d("DB_Helper", "insertDailyWeight method called successfully.")
        val entry = WeightEntry(date, weight)
        weightsRef
            .push()
            .setValue(entry)
            .addOnSuccessListener { onComplete() }
            .addOnFailureListener { e ->
                Log.e("DB", "Write failed", e)
            }
    }

    /** Overwrite the singleton goal weight under /goalWeight */
    fun insertGoalWeight(goalWeight: Double) {
        goalRef.setValue(goalWeight)
    }

    /** Read the current goal weight once */
    fun getGoalWeight(callback: (Double) -> Unit) {
        goalRef.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val gw = snapshot.getValue(Double::class.java) ?: 0.0
                callback(gw)
            }
            override fun onCancelled(error: DatabaseError) { callback(0.0) }
        })
    }

    /** Read the latest daily weight once */
    fun getLatestWeight(callback: (Double) -> Unit) {
        weightsRef.orderByKey()
            .limitToLast(1)
            .addListenerForSingleValueEvent(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val entry = snapshot.children
                        .mapNotNull { it.getValue(WeightEntry::class.java) }
                        .firstOrNull()
                    callback(entry?.weight ?: 0.0)
                }
                override fun onCancelled(error: DatabaseError) { callback(0.0) }
            })
    }

    /** Attaches a real-time listener to all daily weights */
    fun addRealtimeWeightListener(callback: (List<DataGridItem>) -> Unit) {
        weightListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull {
                    it.getValue(WeightEntry::class.java)
                }.map { DataGridItem(it.date, it.weight) }
                callback(list)
            }
            override fun onCancelled(error: DatabaseError) {
                callback(emptyList())
            }
        }
        weightsRef.addValueEventListener(weightListener!!)
    }

    /** Removes the real-time listener to prevent memory leaks */
    fun removeRealtimeWeightListener() {
        weightListener?.let { weightsRef.removeEventListener(it) }
    }

    /** Read all daily weights and return as List<DataGridItem> (This is for the DataGrid) */
    fun getAllDailyWeights(callback: (List<DataGridItem>) -> Unit) {
        weightsRef.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = snapshot.children.mapNotNull {
                    it.getValue(WeightEntry::class.java)
                }.map { DataGridItem(it.date, it.weight) }
                callback(list)
            }
            override fun onCancelled(error: DatabaseError) {
                callback(emptyList())
            }
        })
    }

    /** Delete entry(ies) matching a date & weight */
    fun deleteWeightEntry(date: String, weight: Double) {
        weightsRef.orderByChild("date").equalTo(date)
            .addListenerForSingleValueEvent(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach { ds ->
                        val entry = ds.getValue(WeightEntry::class.java)
                        if (entry?.weight == weight) {
                            ds.ref.removeValue()
                        }
                    }
                }
                override fun onCancelled(error: DatabaseError) { /* no-op */ }
            })
    }
}