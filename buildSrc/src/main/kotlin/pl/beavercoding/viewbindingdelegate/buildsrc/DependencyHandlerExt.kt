package pl.beavercoding.viewbindingdelegate.buildsrc

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementation(dependency: Dependency) {
    add("implementation", dependency)
}
