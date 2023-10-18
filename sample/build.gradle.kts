import pl.beavercoding.viewbindingdelegate.buildsrc.Config
import pl.beavercoding.viewbindingdelegate.buildsrc.Libs

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "pl.beavercoding.viewbindingdelegate"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "pl.beavercoding.viewbindingdelegate"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(":view-binder"))

    // core
    implementation(Libs.Androidx.core)
    implementation(Libs.Androidx.appcompat)

    // views
    implementation(Libs.Google.material)
    implementation(Libs.Androidx.constraintLayout)
    implementation(Libs.Androidx.recyclerView)

    // navigation
    implementation(Libs.Androidx.Navigation.ui)
    implementation(Libs.Androidx.Navigation.fragment)

    // leakcanary
    debugImplementation(Libs.CanaryLeak.android)
    androidTestImplementation(Libs.CanaryLeak.androidTests)

    // tests
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.Androidx.Test.junitExt)
    androidTestImplementation(Libs.Androidx.Test.espresso)
}
