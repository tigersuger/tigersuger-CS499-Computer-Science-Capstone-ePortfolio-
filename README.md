

# CS 499 Capstone: Android Weight Tracker Mobile App with Firebase

This repository serves as the ePortfolio for my Computer Science Capstone project. It showcases the complete lifecycle of the **Weight Tracker** mobile application — from its origins as a legacy Java project to a modern, cloud-enabled Android app built with Kotlin and Firebase Realtime Database.

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-7F52FF?style=for-the-badge\&logo=kotlin)](https://kotlinlang.org/)
[![Firebase](https://img.shields.io/badge/Firebase-Realtime_Database-FFCA28?style=for-the-badge\&logo=firebase)](https://firebase.google.com/)
[![Android Studio](https://img.shields.io/badge/Android_Studio-Hedgehog-3DDC84?style=for-the-badge\&logo=android-studio)](https://developer.android.com/studio)
[![Gradle](https://img.shields.io/badge/Gradle-8.x-02303A?style=for-the-badge\&logo=gradle)](https://gradle.org/)

---

## 🎥 Video Code Review & Walkthrough

A comprehensive video walkthrough covering the app’s architecture, key enhancements, and functionality is available on YouTube:
👉 [**Watch the full video presentation**](https://youtu.be/VpGz-RmhuNc)

---

## 📚 Table of Contents

* [Project Overview](#project-overview)
* [Core Features](#core-features)
* [Key Technical Enhancements](#key-technical-enhancements)

  * [1. Codebase Modernization (Java to Kotlin)](#1-codebase-modernization-java-to-kotlin)
  * [2. Data Visualization (Trend Graph)](#2-data-visualization-trend-graph)
  * [3. Database Migration & Real-Time Sync (Firebase)](#3-database-migration--real-time-sync-firebase)
* [Technology Stack](#technology-stack)
* [Project Evolution & Source Code](#project-evolution--source-code)
* [Author](#author)

---

## 📱 Project Overview

The **Weight Tracker** app provides a simple yet powerful tool for users to monitor their weight, set personal goals, and visualize their progress over time. The project began as a basic Java application and evolved into a robust, cloud-first mobile app — demonstrating full-cycle software engineering capabilities.

---

## ✨ Core Features

✅ **Daily Weight Logging:** Enter and save weight data to the cloud in real-time.
✅ **Goal Weight Setting:** Set and update personal target goals.
✅ **Real-Time Data Grid:** Live, scrollable list of all historical weight entries (most recent first).
✅ **Interactive Trend Graph:** Dynamic chart to visualize weight trends and progress.
✅ **Cloud-Persisted Data:** Secure storage via Firebase Realtime Database — access your data anytime, anywhere.

---

## 🚀 Key Technical Enhancements

### 1️⃣ Codebase Modernization (Java → Kotlin)

* Migrated entire legacy codebase to idiomatic Kotlin.
* Boosted code safety by leveraging Kotlin’s null-safety.
* Improved readability using modern Kotlin features (data classes, type inference, scope functions).
* Increased maintainability and aligned with modern Android best practices.

### 2️⃣ Data Visualization (Trend Graph)

* Integrated [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) library for rich, interactive visualizations.
* Designed and implemented the “Trend Graph” screen to graph weight data.
* Converted raw weight entries (`List<DataGridItem>`) into the chart’s `Entry` format.
* Applied sorting and data transformation to ensure accuracy of the graph.

### 3️⃣ Database Migration & Real-Time Sync (Firebase)

* Replaced local SQLite database with **Firebase Realtime Database** for cloud-based persistence.
* Implemented live, two-way data binding with Firebase listeners (`addValueEventListener`).
* Made the app fully reactive — weight logs and charts update instantly on any data change.
* Resolved Firebase SDK integration, Gradle conflicts, and ensured stable connections via explicit database URL configuration.
* Added proper memory management: detached Firebase listeners on screen destroy to avoid memory leaks and improve app stability.

---

## 🛠️ Technology Stack

| Component          | Technology                                                                           |
| ------------------ | ------------------------------------------------------------------------------------ |
| Language           | [Kotlin](https://kotlinlang.org/)                                                    |
| Framework          | [Android SDK](https://developer.android.com/studio)                                  |
| Cloud Database     | [Firebase Realtime Database](https://firebase.google.com/products/realtime-database) |
| Data Visualization | [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart)                          |
| Build System       | [Gradle](https://gradle.org/)                                                        |

---

## 🌱 Project Evolution & Source Code

You can follow the evolution of the app through these branches:

* [**Original Artifact**](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/Original_Artifact) — initial legacy Java application.
* [**Week 3 - Enhancement One**](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/Week3) — modernized Kotlin codebase.
* [**Week 4 - Enhancement Two**](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/week4) — addition of Trend Graph.
* [**Week 5 - Enhancement Three**](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/Week5) — full Firebase Realtime Database migration.
* [**Final Enhanced Code Files**](https://github.com/tigersuger/tigersuger-CS499-Computer-Science-Capstone-ePortfolio-/tree/Enhanced-Code-Files) — completed, production-ready application.

---

## 👨‍💻 Author

**Phong Nguyen**
[GitHub Profile](https://github.com/tigersuger)

---

If you want, I can also suggest some additional ideas to make the README *even more attractive* — like adding screenshots of the app or badges for license & version — just tell me! 🚀
