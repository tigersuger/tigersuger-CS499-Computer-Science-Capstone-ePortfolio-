**Milestone 2 Enhancement – Software Design & Engineering -  Week 3**

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

<p align="center"> Legacy Layout  </p>

![image](https://github.com/user-attachments/assets/02bd1a00-9465-482d-8922-c179cee27304)
![image](https://github.com/user-attachments/assets/b2468651-f6d2-401a-b53f-7f846e772c95)

<p align="center">Enhanced Layout</p>

![image](https://github.com/user-attachments/assets/4e4b05c3-4e58-47b6-94ad-303e0f4f2efb)
![image](https://github.com/user-attachments/assets/71d94600-b6bc-4948-a97e-fe328155640c)
![image](https://github.com/user-attachments/assets/289f17ff-78f8-430e-8736-459d7665858d)



