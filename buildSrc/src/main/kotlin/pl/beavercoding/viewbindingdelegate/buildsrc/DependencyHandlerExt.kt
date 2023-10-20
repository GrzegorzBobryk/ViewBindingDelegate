package pl.beavercoding.viewbindingdelegate.buildsrc

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandler.implementation(dependency: Dependency) {
    add("implementation", dependency)
}

// https://github.com/detekt/detekt/issues/6555
fun DependencyHandlerScope.detektPlugins(dependencyNotation: Any) {
    add("detektPlugins", dependencyNotation)
}
