import pl.beavercoding.viewbindingdelegate.buildsrc.Config

plugins {
    id("com.android.library")
    id("kotlin-android")
    `maven-publish`
}

android {
    namespace = "pl.beavercoding.viewBinder"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = Libs.java
        targetCompatibility = Libs.java
    }
    kotlinOptions {
        jvmTarget = Libs.java.toString()
    }
}

dependencies {
    implementation(Libs.Androidx.appcompat)
    implementation(Libs.Androidx.viewBinding)
    implementation(Libs.Androidx.recyclerView)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["release"])

                groupId = "com.github.grzegorzbobryk"
                artifactId = "view-binder"
                version = "1.0.8-alpha.2"
            }
        }
    }
}
