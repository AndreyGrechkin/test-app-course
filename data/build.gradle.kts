plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.defey.testcourse.data"
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
}

dependencies {

    implementation(project(":core"))
    // AndroidX
    implementation(Libs.coreKtx)
    implementation(Libs.coroutinesAndroid)

    // Network
    implementation(Libs.retrofit)
    implementation(Libs.retrofitGson)
    implementation(Libs.okhttp)
    implementation(Libs.okhttpLogging)
    implementation(Libs.moshi)

    // Database
    implementation(Libs.roomRuntime)
    implementation(Libs.roomKtx)
    kapt(Libs.roomCompiler)

    // Dagger 2
    implementation(Libs.dagger)
    kapt(Libs.daggerCompiler)
    implementation(Libs.javaxInject)
}