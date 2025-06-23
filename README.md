

# CS 499 Capstone Project: WeightTracker Mobile Application

Welcome to my Enhanced-Code-Files Branch. This project showcases the development and enhancement of the **WeightTracker Mobile App**, a modern Android mobile application built in Kotlin and powered by Firebase Realtime Database.

The project involved a full modernization of a legacy Java-based app, transforming it from a simple on-device tracker into a robust, cloud-enabled platform with real-time capabilities. This repository contains the final, enhanced source code, demonstrating key software engineering competencies.

## Key Enhancements and Features

### 1. Codebase Modernization (Java → Kotlin)

* Migrated the entire legacy Java codebase to modern, idiomatic Kotlin.
* Improved code safety (null safety), readability, and maintainability.
* Enabled easier future enhancements with concise and expressive Kotlin syntax.

### 2. Data Visualization with MPAndroidChart

* **Trend Graph**: Added a new feature that visually displays weight progress over time.
* Integrated the **MPAndroidChart** third-party library:

  * Configured Gradle with JitPack repository.
  * Learned and implemented the library's API.
* Implemented logic to transform and sort user weight data into the required `Entry` format for the chart.

### 3. Cloud Database Migration (SQLite → Firebase Realtime Database)

* Migrated from a local SQLite database to Firebase Realtime Database for cloud-based data storage.
* Benefits:

  * Persistent, secure, and easily accessible data from any device.
* Integrated Firebase SDK:

  * Configured `google-services.json`.
  * Resolved Gradle dependency conflicts.
  * Centralized repository management in `settings.gradle.kts`.
  * Explicitly defined the database URL for a stable connection.

### 4. Real-Time Data Synchronization

* Leveraged Firebase’s `addValueEventListener` for real-time updates.
* Created a reactive UI:

  * Instantly reflects changes to weight entries on both the data grid and trend graph—no manual refresh required.
  * UI update logic is embedded within Firebase listeners.
* Implemented proper memory management:

  * Cleaned up listeners in `onDestroy()` to prevent memory leaks and ensure app stability.

---

If you'd like, I can also help you format it in proper Markdown with headings, code blocks, and links for an even more polished GitHub README!
