plugins {
    id("com.android.library")
}

android {
    namespace = "com.bumptech.glide.integration.avif"

    defaultConfig {
        minSdk = libs.versions.min.sdk.version.get().toInt()
        compileSdk = 34

        // versionName = " " // VERSION_NAME as String
    }

//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
}

dependencies {
    implementation(project(":library"))
    implementation("org.aomedia.avif.android:avif:1.1.1.14d8e3c4")
    implementation(libs.guava)

    // annotationProcessor(project(":annotation:compiler"))
}

// apply from: "${rootProject.projectDir}/scripts/upload.gradle"
