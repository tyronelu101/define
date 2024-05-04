plugins {
    `kotlin-dsl`
}

group = "com.example.define.buildlogic"

dependencies {
    compileOnly(libs.android.tools.build.gradle)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

gradlePlugin {
    plugins {
        create("androidApplication") {
            id = "com.example.define.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
    }
}