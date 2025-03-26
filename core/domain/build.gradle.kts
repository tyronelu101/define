plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.google.dagger.hilt)
    alias(libs.plugins.google.devtools.ksp)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.define.core.domain"
    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:models"))
    implementation(project(":core:network"))

    implementation(libs.google.dagger.hilt)
    implementation(libs.androidx.core.ktx)
    ksp(libs.google.dagger.hilt.compiler)
}