plugins {
    alias(libs.plugins.android.library)

    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.google.devtools.ksp)

    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.compose.compiler)

    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.example.define.feature.dictionary"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    dependencies {
        implementation(project(":core:data"))
        implementation(project(":core:dictionary-loaders"))
        implementation(project(":core:domain"))
        implementation(project(":core:models"))
        implementation(project(":core:ui"))
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.hilt.navigation.compose)
        implementation(libs.androidx.navigation.compose)
        implementation(libs.androidx.material3)
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.google.dagger.hilt)
        ksp(libs.google.dagger.hilt.compiler)
        implementation(libs.jetbrains.kotlinx.datetime)
        implementation(libs.jetbrains.kotlinx.serialization.json)

    }
}