plugins {
    id("com.android.library")
}

android {
    namespace = "com.bumptech.glide.integration.okhttp"

    defaultConfig {
        minSdk = libs.versions.okhttp.min.sdk.version.get().toInt()
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
    annotationProcessor(project(":annotation:compiler"))

    api(libs.okhttp4)
    api(libs.androidx.annotation)
}

// apply from: "${rootProject.projectDir}/scripts/upload.gradle"
