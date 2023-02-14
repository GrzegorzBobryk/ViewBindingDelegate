@file:Suppress("unused")

package pl.beavercoding.viewbindingdelegate.buildsrc

object Libs {
    private const val androidGradlePluginVersion = "7.4.1"
    const val androidGradlePlugin = "com.android.tools.build:gradle:$androidGradlePluginVersion"
    const val junit = "junit:junit:4.13.2"

    object Androidx {
        const val core = "androidx.core:core-ktx:1.9.0"
        const val appcompat = "androidx.appcompat:appcompat:1.6.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val viewBinding = "androidx.databinding:viewbinding:$androidGradlePluginVersion"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"


        object Navigation {
            private const val version = "2.5.3"

            const val safeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Test {
            const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
            const val junitExt = "androidx.test.ext:junit-ktx:1.1.5"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.8.0"
    }

    object Kotlin {
        private const val version = "1.8.0"

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object CanaryLeak {
        private const val version = "2.10"

        const val android = "com.squareup.leakcanary:leakcanary-android:$version"
        const val androidTests = "com.squareup.leakcanary:leakcanary-android-instrumentation:$version"
    }

}
