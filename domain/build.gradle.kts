plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
}

android {
    namespace = "com.defey.testcourse.domain"
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
    // Только самые базовые зависимости
    implementation(project(":data"))
    implementation(project(":core"))
    implementation(Libs.kotlinStdlib)
    implementation(Libs.coroutinesCore)
    implementation(Libs.javaxInject)

    // Dagger 2
    implementation(Libs.dagger)
    implementation(Libs.javaxInject)
}