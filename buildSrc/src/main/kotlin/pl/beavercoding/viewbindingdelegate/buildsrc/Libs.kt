@file:Suppress("PackageDirectoryMismatch") // this way it will work in project build.gradle.kts

import org.gradle.api.JavaVersion
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import pl.beavercoding.viewbindingdelegate.buildsrc.implementation

object Libs {
    private const val androidGradlePluginVersion = "8.5.1"
    const val androidGradlePlugin = "com.android.tools.build:gradle:$androidGradlePluginVersion"
    const val junit = "junit:junit:4.13.2"
    val java = JavaVersion.VERSION_1_8

    object Androidx {
        const val core = "androidx.core:core-ktx:1.13.1"
        const val appcompat = "androidx.appcompat:appcompat:1.7.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val viewBinding = "androidx.databinding:viewbinding:$androidGradlePluginVersion"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.3.2"

        object Navigation {
            private const val version = "2.7.7"

            const val safeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Test {
            const val espresso = "androidx.test.espresso:espresso-core:3.6.1"
            const val junitExt = "androidx.test.ext:junit-ktx:1.2.1"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.12.0"
    }

    object Kotlin {
        private const val version = "1.9.25"

        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object CanaryLeak {
        private const val version = "2.14"

        const val android = "com.squareup.leakcanary:leakcanary-android:$version"
        const val androidTests = "com.squareup.leakcanary:leakcanary-android-instrumentation:$version"
    }

    object Detekt {
        private const val version = "1.23.6"
        const val detektGradlePlugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:$version"
        const val detektFormatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"
        const val detektPlugin = "io.gitlab.arturbosch.detekt"
    }

}

fun DependencyHandler.viewBinder() {
    implementation(project(":view-binder"))
}
