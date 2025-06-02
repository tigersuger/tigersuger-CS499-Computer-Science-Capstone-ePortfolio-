**Milestone 2 Enhancement – Software Design & Engineering**

Migrated the original WeightTrackerMobileApp from Java to Kotlin, showcasing modern software engineering practices and end-to-end mobile development skills. Key points include:

* **Rewritten in Kotlin**: Eliminated boilerplate (getters/setters) in favor of idiomatic constructs (data classes, companion objects, scope functions).
* **Improved Architecture**:

  * Consolidated separate Login/Register screens into a single MainActivity.kt.
  * Separated responsibilities into helper classes and adapters (e.g., DataGridAdapter.kt and TrendCalculator.kt).
  * Ensured cohesive, modular components (Activities vs. utility classes vs. adapters).
* **Enhanced Null Safety & Resource Management**:

  * Replaced manual cursor handling with `writableDatabase.use { … }` blocks.
  * Utilized Kotlin’s nullable types and `lateinit` to prevent runtime crashes.
* **Modernized UI & Feature Flow**:

  * Unified permissions handling in SMSPermissionActivity.kt using `registerForActivityResult`.
  * Added trend visualization via MPAndroidChart in TrendActivity.kt, with a stateless TrendCalculator object to generate data.
* **Skills Demonstrated**:

  * Kotlin fluency: lambda-based click listeners, string templates, scoped functions.
  * Code maintainability: clear naming (e.g., DataGridItem.kt), concise utility methods.
  * Version control & collaboration: Git branching, peer reviews, and narrative code comments.
* **Outcome Alignment**:

  * Met Outcome 4 (Software Engineering Techniques) by fully migrating and refactoring the codebase.
  * Addresses ongoing work for Outcomes 1–5 (Collaboration, Communication, Algorithmic Problem Solving, Security & Databases).

This enhancement highlights the transition from a legacy Java codebase to a clean, idiomatic Kotlin implementation, demonstrating proficiency in modern Android development and software design principles.

