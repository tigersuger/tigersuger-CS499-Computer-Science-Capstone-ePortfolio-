**Milestone 3 Enhancement – Algorithms & Data Structures - Week 4**

* **Trend Graph Feature:**
  Added a new `TrendGraphActivity.kt` (and corresponding `activity_trend_graph.xml`) that leverages MPAndroidChart to plot a user’s historical weight entries as a continuous line chart—each data point annotated with its numeric value.

* **Data Retrieval & Sorting:**
  Fetched all daily weights from SQLite (`databaseHelper.allDailyWeights`), then used `dailyWeights.sortedBy { it.date }` to ensure chronological order before plotting.

* **Kotlin Collection Transformation:**
  Converted the sorted list of `(date: Long, weight: Double)` into `Entry(index.toFloat(), weight.toFloat())` objects via

  ```kotlin
  val entries = sortedWeights.mapIndexed { index, w → Entry(index.toFloat(), w.weight.toFloat()) }
  ```

  demonstrating mapping between a high-level data structure and the chart’s required input.

* **Custom X-Axis Formatting:**
  Built a parallel `List<Long> dates = sortedWeights.map { it.date }` and assigned an anonymous `ValueFormatter` to the chart’s X-axis so that each point’s raw timestamp displays correctly (fallback for a future human-readable format).

* **Edge-Case & UI Handling:**
  Checked for an empty data set—if `dailyWeights.isEmpty()`, show a “No data available” toast and exit early. Ensured the chart updates immediately by calling:

  ```kotlin
  lineChart.data = LineData(dataSet)
  lineChart.notifyDataSetChanged()
  lineChart.invalidate()
  ```

* **Algorithmic & Data-Structure Skills Demonstrated:**

  * Chronological sorting (`sortedBy { it.date }`).
  * Index-based mapping (`mapIndexed { … } → Entry`).
  * Custom formatter logic (`ValueFormatter.getFormattedValue(value: Float)`).

* **Third-Party Library Integration:**
  Added the MPAndroidChart dependency to `app/build.gradle`, modularized chart logic in its own activity, and styled the `LineDataSet` (e.g., circle radius, line width) for readability.

* **Collaboration & Version Control:**
  Implemented all changes on a dedicated Git branch (`feature/trend-graph`), used descriptive commit messages (e.g., “Add TrendGraphActivity: sort daily weights + configure LineChart”), and merged back once testing on emulators confirmed correct behavior.

By transforming raw database rows into an interactive chart, this enhancement highlights proficiency in Kotlin data structures, algorithmic problem solving, and third-party library use—culminating in a more intuitive user experience compared to the previous textual list of entries.
![image](https://github.com/user-attachments/assets/55a19962-9042-4a03-a5a2-20f910648802)
