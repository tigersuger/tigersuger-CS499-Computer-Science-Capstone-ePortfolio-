package com.example.cs499_weighttracker_pn

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter

class TrendGraphActivity : AppCompatActivity() {

    // Use FirebaseDatabaseHelper, not the old DatabaseHelper
    private lateinit var databaseHelper: FirebaseDatabaseHelper
    private lateinit var lineChart: LineChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend_graph)

        // Initialize FirebaseDatabaseHelper
        databaseHelper = FirebaseDatabaseHelper()
        lineChart = findViewById(R.id.lineChart)

        // Attach a real-time listener that updates the chart whenever data changes in Firebase
        databaseHelper.addRealtimeWeightListener { dailyWeights ->
            Log.d("TrendGraph", "Data updated. Number of daily weights: ${dailyWeights.size}")
            if (dailyWeights.isNotEmpty()) {
                // If data exists, call the function to draw the chart
                updateChart(dailyWeights)
            } else {
                // If no data exists, clear the chart and show a message
                lineChart.clear()
                Toast.makeText(this, "No data available to build graph", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // This new function contains the logic to draw or update the chart
    private fun updateChart(dailyWeights: List<DataGridItem>) {
        // Sort weights by date to ensure the line connects in chronological order
        val sortedWeights = dailyWeights.sortedBy { it.date }

        // Create chart entries from the sorted weight data
        val entries = sortedWeights.mapIndexed { index, item ->
            Entry(index.toFloat(), item.weight.toFloat())
        }

        val dataSet = LineDataSet(entries, "Daily Weights").apply {
            color = Color.RED
            lineWidth = 2f
            setCircleColor(Color.RED)
            circleRadius = 5f
            setDrawCircleHole(false)
        }

        val lineData = LineData(dataSet)
        lineChart.data = lineData

        // Configure the X-axis to display dates instead of numbers
        val xAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        val dates = sortedWeights.map { it.date }
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                val index = value.toInt()
                return if (index >= 0 && index < dates.size) dates[index] else ""
            }
        }
        xAxis.granularity = 1f

        // Configure other chart properties
        lineChart.axisLeft.axisMinimum = 0f
        lineChart.axisRight.isEnabled = false
        lineChart.description.isEnabled = false
        lineChart.legend.isEnabled = true

        // Refresh the chart to display the new data
        lineChart.invalidate()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Important: Remove the listener when the activity is destroyed to prevent memory leaks
        databaseHelper.removeRealtimeWeightListener()
    }
}