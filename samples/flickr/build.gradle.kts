plugins {
    id("com.android.application")
}

android {
    namespace = "com.bumptech.glide.samples.flickr"

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

    // This is transitive=false but....how?
    implementation(project(":integration:recyclerview"))

    // kapt I guess?
    // annotationProcessor project(":annotation:compiler")
    // OK maybe not this?
    // kotlin("kapt")
    // kapt(project(":annotation:compiler"))

    implementation(libs.androidx.appcompat)
    implementation(libs.volley)
    implementation(libs.androidx.recyclerview)
}

tasks.register("run", Exec::class) {
    dependsOn("installDebug")
    description = "Installs the APK and runs the main activity: 'gradlew :samples:???:run'"
    commandLine = listOf("${android.sdkDirectory}/platform-tools/adb", "shell", "am", "start", "-n", "com.bumptech.glide.samples.flickr/.FlickrSearchActivity")
}