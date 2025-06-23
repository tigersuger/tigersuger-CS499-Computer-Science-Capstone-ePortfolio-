
```md
# CS 499 Capstone: Android Weight Tracker with Firebase

This repository serves as the ePortfolio for my Computer Science Capstone project. It showcases the complete lifecycle of the **Weight Tracker** mobile application, from its origins as a legacy Java project to its final state as a modern, cloud-enabled Android application built with Kotlin and integrated with the Firebase Realtime Database.

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-7F52FF?style=for-the-badge&logo=kotlin)](https://kotlinlang.org/)
[![Firebase](https://img.shields.io/badge/Firebase-Realtime_Database-FFCA28?style=for-the-badge&logo=firebase)](https://firebase.google.com/)
[![Android Studio](https://img.shields.io/badge/Android_Studio-Hedgehog-3DDC84?style=for-the-badge&logo=android-studio)](https://developer.android.com/studio)
[![Gradle](https://img.shields.io/badge/Gradle-8.x-02303A?style=for-the-badge&logo=gradle)](https://gradle.org/)

---

### ► Video Code Review & Walkthrough

A comprehensive video walkthrough detailing the project's architecture, key enhancements, and functionality is available on YouTube.

- **[Click here to watch the full video presentation](https://youtu.be/VpGz-RmhuNc)**

---

## Table of Contents

- [Project Overview](#project-overview)
- [Core Features](#core-features)
- [Key Technical Enhancements](#key-technical-enhancements)
  - [1. Codebase Modernization (Java to Kotlin)](#1-codebase-modernization-java-to-kotlin)
  - [2. Data Visualization (Trend Graph)](#2-data-visualization-trend-graph)
  - [3. Database Migration & Real-Time Sync (Firebase)](#3-database-migration--real-time-sync-firebase)
- [Technology Stack](#technology-stack)
- [Project Evolution & Source Code](#project-evolution--source-code)

## Project Overview

The Weight Tracker application is designed to be a simple yet powerful tool for users to monitor their weight, set personal goals, and visualize their progress over time. The project's journey began with a basic, on-device Java application, which was then systematically enhanced to meet modern software engineering standards. The final version is a robust, scalable, and reactive mobile application demonstrating a full range of software development competencies.

## Core Features

- **Daily Weight Logging:** Users can input their weight daily, which is instantly saved to the cloud.
- **Goal Weight Setting:** Users can set and update a target goal weight.
- **Real-Time Data Grid:** A scrollable list displays all historical weight entries, sorted with the most recent at the top. This list updates in real-time as data changes.
- **Live Trend Graph:** A dynamic line chart visualizes the user's weight journey over time, providing immediate insight into their progress.
- **Cloud-Based Data Persistence:** All user data is securely stored in the Firebase Realtime Database, ensuring it is never lost and can be accessed from anywhere.

## Key Technical Enhancements

This project was developed through a series of three major enhancements, each targeting a specific area of software engineering.

### 1. Codebase Modernization (Java to Kotlin)

The entire legacy Java codebase was migrated to modern, idiomatic Kotlin. This foundational enhancement was crucial for improving the application's stability, safety, and maintainability.

- **Improved Code Safety:** Eliminated the risk of null pointer exceptions through Kotlin's robust null-safety features.
- **Increased Readability:** Reduced boilerplate code significantly by leveraging Kotlin features like data classes, type inference, and scope functions (`.use{}`), making the code more concise and easier to understand.
- **Maintainability:** Aligned the project with current Android development best practices, ensuring it is easier to update and extend in the future.

### 2. Data Visualization (Trend Graph)

To transform raw data into actionable insight, a data visualization feature was implemented to show users their progress graphically.

- **Third-Party Library Integration:** Successfully integrated the popular `MPAndroidChart` library to render the trend graph, demonstrating the ability to work with external dependencies via Gradle and JitPack.
- **Algorithmic Data Transformation:** Developed the logic to transform the application's list of weight entries (`List<DataGridItem>`) into the specific `Entry` data format required by the chart library, including sorting the data chronologically to ensure the graph was accurate.

### 3. Database Migration & Real-Time Sync (Firebase)

The most significant enhancement was re-architecting the data persistence layer, moving from a local-only SQLite database to a scalable, real-time cloud solution.

- **Cloud Backend:** Replaced the on-device `SQLiteOpenHelper` with a `FirebaseDatabaseHelper` class, migrating the application's data layer to the **Firebase Realtime Database**.
- **Firebase SDK Integration:** Correctly configured the Android project to connect to Firebase. This involved a detailed debugging process that included:
    - Setting up the `google-services.json` configuration file.
    - Resolving dependency conflicts in the `build.gradle.kts` files by removing redundant plugins and centralizing repositories in `settings.gradle.kts`.
    - Explicitly setting the database URL to ensure a reliable connection.
- **Real-Time Data Synchronization:** Implemented Firebase's `addValueEventListener` to create a live, two-way connection between the app and the cloud database.
- **Reactive UI:** The application's UI is now fully reactive. When a user adds or deletes a weight entry on the main screen, both the data grid and the trend graph update **instantly** without requiring a manual refresh. This was achieved by placing all UI update logic inside the Firebase listeners.
- **Memory Management:** Implemented the `onDestroy` lifecycle method to correctly detach the real-time listeners when a screen is closed, preventing memory leaks and ensuring application stability.

## Technology Stack

- **Language:** [Kotlin](https://kotlinlang.org/)
- **Framework:** [Android SDK](https://developer.android.com/studio)
- **Database:** [Firebase Realtime Database](https://firebase.google.com/products/realtime-database)
- **Data Visualization:** [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)
- **Build System:** [Gradle](https://gradle.org/)

## Project Evolution & Source Code

This repository documents the complete evolution of the project. You can explore the state of the codebase at each key stage via the following branches:

- **[Original Artifact](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/Original_Artifact):** The initial legacy Java application.
- **[Week 3 - Enhancement One](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/Week3):** The fully modernized Kotlin codebase.
- **[Week 4 - Enhancement Two](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/week4):** The addition of the Trend Graph data visualization.
- **[Week 5 - Enhancement Three](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/Week5):** The final migration to the Firebase Realtime Database.
- **[Final Enhanced Code Files](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/Enhanced-Code-Files):** The complete, final version of the application.

---

### Author

* **Phong Nguyen**
```
