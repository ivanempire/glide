plugins {
    id("com.android.library")
}

android {
    namespace = "com.bumptech.glide.integration.recyclerview"

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
    compileOnly(libs.androidx.recyclerview)
    compileOnly(libs.androidx.fragment)
}

// apply from: "${rootProject.projectDir}/scripts/upload.gradle"
