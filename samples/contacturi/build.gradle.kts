plugins {
    id("com.android.application")
}

android {
    namespace = "com.bumptech.glide.samples.contacturi"

    defaultConfig {
        minSdk = libs.versions.min.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()
        compileSdk = 34

        versionCode = 1
        versionName = "1.0"
    }

//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
}

dependencies {
    implementation(project(":library"))
    implementation(libs.androidx.appcompat)
    annotationProcessor(project(":annotation:compiler"))
}

//task run(type: Exec, dependsOn: "installDebug") {
//    description "Installs the APK and runs the main activity: "gradlew :samples:???:run""
//    commandLine "${android.sdkDirectory}/platform-tools/adb", "shell", "am", "start", "-n", "com.bumptech.glide.samples.contacturi/.MainActivity"
//}
