import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import pl.beavercoding.viewbindingdelegate.buildsrc.detektPlugins

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(Libs.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
        classpath(Libs.Androidx.Navigation.safeArgsPlugin)
        classpath(Libs.Detekt.detektGradlePlugin)
    }
}

allprojects {
    apply(plugin = Libs.Detekt.detektPlugin)

    dependencies {
        detektPlugins(Libs.Detekt.detektFormatting)
    }

    configure<DetektExtension> {
        debug = true
        allRules = false
        parallel = true
        config.setFrom(files("$rootDir/config/detekt.yml"))
        buildUponDefaultConfig = true
        ignoredBuildTypes = listOf("release")
    }
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
        xml.required.set(false)
        txt.required.set(false)
        sarif.required.set(false)
        md.required.set(false)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
