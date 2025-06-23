Capstone Project: WeightTracker Mobile Application (Android Application)
This project involved modernizing a legacy Android application and transforming it from a simple, on-device tool into a powerful, cloud-enabled platform with real-time capabilities.

Key Enhancements and Features Implemented:
1. Codebase Modernization (Java to Kotlin)
The entire legacy Java codebase was migrated to modern, idiomatic Kotlin. This significantly improved code safety by eliminating null pointer exceptions, increased readability with concise syntax, and made the application more maintainable for future development.

2. Data Visualization with a Third-Party Library
Trend Graph: A new "Trend Graph" feature was implemented to provide users with an intuitive visual representation of their weight progress over time.

MPAndroidChart Integration: Successfully integrated the popular MPAndroidChart third-party library. This involved adding the JitPack repository to the Gradle configuration and learning the library's API.

Data Transformation: Developed the logic to transform the application's list of weight entries into the specific Entry data format required by the chart library, including sorting the data chronologically to ensure the graph was accurate.

3. Database Migration to the Cloud (SQLite to Firebase)
Cloud-Based Backend: The application's entire data persistence layer was migrated from a local, on-device SQLite database to the Firebase Realtime Database. This ensures that user data is persistent, secure, and accessible from anywhere.

Firebase SDK Integration: Correctly configured the Android project to connect to Firebase. This involved a detailed debugging process that included:

Setting up the google-services.json configuration file.

Resolving dependency conflicts in the build.gradle.kts files by removing redundant plugins and centralizing repositories in settings.gradle.kts.

Explicitly setting the database URL to ensure a reliable connection.

4. Real-Time Data Synchronization
Live Data: Implemented Firebase's addValueEventListener to create a live, real-time connection between the app and the cloud database.

Reactive UI: The application's UI is now fully reactive. When a user adds or deletes a weight entry on the main screen, both the data grid and the trend graph update instantly without requiring a manual refresh. This was achieved by placing all UI update logic inside the Firebase listeners.

Memory Management: Implemented the onDestroy lifecycle method to remove the real-time listeners when the user leaves a screen, preventing memory leaks and ensuring application stability.
