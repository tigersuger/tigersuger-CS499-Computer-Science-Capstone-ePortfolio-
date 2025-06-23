package com.example.cs499_weighttracker_pn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import android.util.Log
// Removed redundant import statement

class DataGridActivity : AppCompatActivity() {

    private lateinit var dbHelper: FirebaseDatabaseHelper
    private lateinit var goalWeightInput: EditText
    private lateinit var currentWeightInput: EditText
    private lateinit var currentGoalWeightText: TextView
    private lateinit var todaysWeightText: TextView
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_grid)

        // Initialize Firebase helper
        dbHelper = FirebaseDatabaseHelper()

        goalWeightInput       = findViewById(R.id.goalWeightInput)
        currentWeightInput    = findViewById(R.id.currentWeightInput)
        currentGoalWeightText = findViewById(R.id.currentGoalWeightText)
        todaysWeightText      = findViewById(R.id.todaysWeightText)
        recyclerView          = findViewById(R.id.dataGridRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initial load: goal & latest weight, then the log
        dbHelper.getGoalWeight { gw ->
            currentGoalWeightText.text = getString(
                R.string.current_goal_weight_format, gw
            )
        }
        dbHelper.getLatestWeight { lw ->
            todaysWeightText.text = getString(
                R.string.current_weight_value_format, lw
            )
        }
        loadDailyWeights()

        // Set a new goal weight
        findViewById<Button>(R.id.setGoalButton).setOnClickListener {
            val text = goalWeightInput.text.toString()
            if (text.isNotEmpty()) {
                val gw = text.toDouble()
                dbHelper.insertGoalWeight(gw)
                currentGoalWeightText.text = getString(
                    R.string.current_goal_weight_format, gw
                )
            }
        }

        // Replace your existing addDailyWeightButton listener with this one
        findViewById<Button>(R.id.addDailyWeightButton).setOnClickListener {
            Log.d("DataGridActivity", "Add Daily Weight button clicked.")
            val txt = currentWeightInput.text.toString()

            if (txt.isNotEmpty()) {
                try {
                    // This block will catch errors if the input is not a valid number
                    val wt = txt.toDouble()
                    val date = currentDate
                    Log.d("DataGridActivity", "Attempting to insert weight: $wt for date: $date")

                    // write + reload in the success callback
                    dbHelper.insertDailyWeight(date, wt) {
                        Log.d("DataGridActivity", "Success callback executed. Reloading list.")
                        // 1) update the “Today’s Weight” label
                        todaysWeightText.text = getString(
                            R.string.current_weight_value_format,
                            wt
                        )
                        // 2) re‐load the entire log
                        loadDailyWeights()
                        // 3) check goal & toast if needed
                        dbHelper.getGoalWeight { gw ->
                            if (wt <= gw) {
                                Toast.makeText(
                                    this,
                                    "Congratulations! You've reached your goal weight!",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                } catch (e: NumberFormatException) {
                    // Show an error message if the input was not a valid number
                    Log.e("DataGridActivity", "Invalid number entered: $txt", e)
                    Toast.makeText(this, "Please enter a valid weight.", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Show a message if the input box was empty
                Toast.makeText(this, "Please enter today's weight.", Toast.LENGTH_SHORT).show()
            }
        }


        // SMS & Trend Graph buttons unchanged
        findViewById<Button>(R.id.smsPermissionButton).setOnClickListener {
            startActivity(Intent(this, SMSPermissionActivity::class.java))
        }
        findViewById<Button>(R.id.trendGraphButton).setOnClickListener {
            startActivity(Intent(this, TrendGraphActivity::class.java))
        }
    }

    /** Reloads the RecyclerView from Firebase */
    private fun loadDailyWeights() {
        dbHelper.getAllDailyWeights { list ->
            val adapter = DataGridAdapter(list,
                object : DataGridAdapter.OnDeleteClickListener {
                    override fun onDeleteClick(date: String, weight: Double) {
                        dbHelper.deleteWeightEntry(date, weight)
                        loadDailyWeights()
                    }
                })
            recyclerView.adapter = adapter
        }
    }

    /** Returns today’s date in yyyy-MM-dd format */
    private val currentDate: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return sdf.format(Date())
        }
}