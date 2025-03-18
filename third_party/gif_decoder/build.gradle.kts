plugins {
    id("com.android.library")
}

android {
    namespace = "com.bumptech.glide.gifdecoder"

    defaultConfig {
        compileSdk = 34
        minSdk = libs.versions.min.sdk.version.get().toInt()
    }
}

dependencies {
    implementation(libs.androidx.annotation)

    testImplementation(project(":testutil"))
    testImplementation(libs.androidx.annotation)
    testImplementation(libs.truth)
    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.robolectric)
}

// apply from: "${rootProject.projectDir}/scripts/upload.gradle"
