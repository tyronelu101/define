plugins {
    alias(libs.plugins.android.library)

    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.google.devtools.ksp)

    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.compose.compiler)
    alias(libs.plugins.jetbrains.kotlin.serialization)

}
android {
    namespace = "com.example.define.feature.settings"
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
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.hilt.navigation.compose)
        implementation(libs.androidx.navigation.compose)
        implementation(libs.androidx.material3)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.google.dagger.hilt)
        implementation(libs.jetbrains.kotlinx.serialization.json)

        ksp(libs.google.dagger.hilt.compiler)

    }
}