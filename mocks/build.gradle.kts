plugins {
    id("com.android.library")
}

android {
    namespace = "com.bumptech.glide.mocks"

    defaultConfig {
        minSdk = libs.versions.min.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()
        compileSdk = 34

        // versionName = VERSION_NAME as String
    }

//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
}

dependencies {
    implementation(project(":library"))
    implementation(libs.androidx.annotation)
    implementation(libs.guava)
    implementation(libs.mockito)
}

// apply from: "${rootProject.projectDir}/scripts/upload.gradle"
