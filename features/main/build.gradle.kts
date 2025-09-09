plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.defey.testcourse.main"
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core"))
    implementation(project(":uicore"))

    // AndroidX
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.fragment)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycleLivedata)
    implementation(Libs.navigationFragment)

    // Dagger 2
    implementation(Libs.dagger)
    kapt(Libs.daggerCompiler)
    implementation(Libs.javaxInject)

    //Navigation
    implementation(Libs.cicerone)

    // Coroutines
    implementation(Libs.coroutinesAndroid)
}