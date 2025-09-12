plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
}

android {
    namespace = "com.defey.testcourse.core"
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
    // Общие зависимости
    implementation(Libs.kotlinStdlib)
    implementation(Libs.coreKtx)
    implementation(Libs.coroutinesAndroid)

    //Navigation
    implementation(Libs.cicerone)

    // DI
    implementation(Libs.dagger)
    implementation(Libs.javaxInject)
}