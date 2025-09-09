buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.12.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.10")
    }
}

plugins {
    id("com.android.application") version "8.12.2" apply false
    id("com.android.library") version "8.12.2" apply false
    id("org.jetbrains.kotlin.android") version "2.2.10" apply false
    id("org.jetbrains.kotlin.kapt") version "2.2.10" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

