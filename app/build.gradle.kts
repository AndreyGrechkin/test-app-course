plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.defey.testcourse"
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.defey.testcourse"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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

    // Модули проекта
    implementation(project(":features:auth"))
    implementation(project(":features:courses"))
    implementation(project(":core"))
    implementation(project(":uicore"))
    implementation(project(":data"))
    implementation(project(":domain"))

    // AndroidX
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)
    implementation(Libs.fragment)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycleLivedata)
    implementation(Libs.lifecycleRuntime)

    // Dagger 2
    implementation(Libs.dagger)
    implementation(Libs.daggerAndroid)
    implementation(Libs.daggerAndroidSupport)
    kapt(Libs.daggerCompiler)
    kapt(Libs.daggerAndroidProcessor)
    implementation(Libs.javaxInject)
    implementation(Libs.javaxInject)

    //Navigation
    implementation(Libs.cicerone)

    // Test
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.androidJunit)
    androidTestImplementation(Libs.espresso)
}