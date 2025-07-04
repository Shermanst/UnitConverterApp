// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    // Apply Android and Kotlin plugins only when needed in subprojects
    kotlin("android") version "1.9.20" apply false
    kotlin("kapt") version "1.9.20" apply false
    id("com.android.application") version "8.10.1" apply false
    id("com.android.library") version "8.10.1" apply false
    id("com.google.dagger.hilt.android") version "2.51" apply false
}
