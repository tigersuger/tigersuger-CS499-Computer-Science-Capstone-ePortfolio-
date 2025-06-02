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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trend_graph)

        // Initialize DatabaseHelper
        val databaseHelper = DatabaseHelper(this)

        // Fetch daily weights
        val dailyWeights = databaseHelper.allDailyWeights
        Log.d("TrendGraph", "Number of daily weights: ${dailyWeights.size}")

        // Check if data is empty
        if (dailyWeights.isEmpty()) {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            return
        }

        // Sort weights by date
        val sortedWeights = dailyWeights.sortedBy { it.date }

        // Log the data for debugging
        sortedWeights.forEach {
            Log.d("TrendGraph", "Date: ${it.date}, Weight: ${it.weight}")
            if (it.weight.isNaN() || it.weight.isInfinite()) {
                Log.e("TrendGraph", "Invalid weight detected for date ${it.date}")
            }
        }

        // Create chart entries
        val entries = sortedWeights.mapIndexed { index, item ->
            Entry(index.toFloat(), item.weight.toFloat())
        }

        // Create LineDataSet with enhanced visibility
        val dataSet = LineDataSet(entries, "Daily Weights").apply {
            setColor(Color.RED) // Use a bright, explicit color
            setLineWidth(2f)
            setCircleColor(Color.RED)
            setCircleRadius(5f) // Larger circles for visibility
            setDrawCircleHole(false)
        }

        // Create LineData
        val lineData = LineData(dataSet)

        // Initialize and configure the LineChart
        val lineChart = findViewById<LineChart>(R.id.lineChart)
        lineChart.data = lineData

        // Configure X-axis
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

        // Configure Y-axis
        lineChart.axisLeft.axisMinimum = 0f
        lineChart.axisRight.isEnabled = false

        // Customize chart
        lineChart.description.isEnabled = false
        lineChart.legend.isEnabled = true

        // Refresh the chart
        lineChart.notifyDataSetChanged()
        lineChart.invalidate()
    }
}