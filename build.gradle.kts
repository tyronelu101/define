// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false

    alias(libs.plugins.google.dagger.hilt) apply false
    alias(libs.plugins.google.devtools.ksp) apply false
    alias(libs.plugins.google.protobuf) apply false

    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.compose.compiler) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.android.dynamic.feaure) apply false
}