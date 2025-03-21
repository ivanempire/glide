plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.bumptech.glide.integration.sqljournaldiskcache"

    defaultConfig {
        minSdk = libs.versions.min.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()
        compileSdk = 34

        // versionName VERSION_NAME as String
    }

//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
}

dependencies {
    implementation(project(":library"))
    implementation(libs.errorprone.annotations)

    testImplementation(libs.guava.testlib)
    testImplementation(libs.truth)
    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.robolectric)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.junit)
    testImplementation(libs.androidx.test.runner)
}

// apply from: "${rootProject.projectDir}/scripts/upload.gradle"
