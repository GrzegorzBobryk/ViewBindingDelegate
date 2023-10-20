import pl.beavercoding.viewbindingdelegate.buildsrc.Config

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
        sourceCompatibility = Libs.java
        targetCompatibility = Libs.java
    }
    kotlinOptions {
        jvmTarget = Libs.java.toString()
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    viewBinder()

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
