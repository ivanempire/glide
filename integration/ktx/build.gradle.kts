plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.bumptech.glide.integration.ktx"

    defaultConfig {
        minSdk = libs.versions.min.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()
        compileSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

// Enable strict mode, but exclude tests.
//tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile) {
//    if (!it.name.contains("Test")) {
//        kotlinOptions.freeCompilerArgs += "-Xexplicit-api=strict"
//    }
//}

dependencies {
    api(project(":library"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.coroutines.core)
    testImplementation(libs.androidx.espresso)
    testImplementation(libs.androidx.espresso.idling)
    testImplementation(libs.androidx.test.ktx)
    testImplementation(libs.kotlin.junit)
    testImplementation(libs.androidx.test.ktx.junit)
    testImplementation(libs.androidx.junit)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.test.runner)
    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.truth)
    androidTestImplementation(libs.androidx.junit)
}

//apply from: "${rootProject.projectDir}/scripts/upload.gradle"
