plugins {
    id("com.android.application")
}

android {
    namespace = "com.bumptech.glide.samples.imgur"

    defaultConfig {
        minSdk = libs.versions.min.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()
        compileSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":library"))
    annotationProcessor(project(":annotation:compiler"))

    implementation(libs.dagger)
    implementation(libs.dagger.android)
    annotationProcessor(libs.dagger.compiler)
    annotationProcessor(libs.dagger.android.processor)

    implementation(libs.okhttp3)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.rxjava)

    implementation(libs.rx.android)
    implementation(libs.rx.java)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.recyclerview)

    // Fixes a compilation warning related to dagger, see
    // https://github.com/google/guava/issues/2721.
    compileOnly(libs.errorprone.annotations)
}

//task run(type: Exec, dependsOn: "installDebug") {
//    description "Installs the APK and runs the main activity: "gradlew :samples:???:run""
//    commandLine "${android.sdkDirectory}/platform-tools/adb", "shell", "am", "start", "-n", "com.bumptech.glide.samples.card/.MainActivity"
//}
