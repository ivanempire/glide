plugins {
    id("com.android.library")
}

android {
    namespace = "com.bumptech.glide.integration.volley"

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
    api(libs.volley)
    api(libs.androidx.annotation)
    annotationProcessor(project(":annotation:compiler"))

    testImplementation(project(":testutil"))
    testImplementation(libs.truth)
    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.robolectric)
    testImplementation(libs.mockwebserver)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.junit)
    testImplementation(libs.androidx.test.runner)
}

//apply from: "${rootProject.projectDir}/scripts/upload.gradle"
