plugins {
    id("com.android.library")
}

//checkstyle {
//    toolVersion = "6.19"
//    configFile = new File(projectDir, "checkstyle.xml")
//}

android {
    namespace = "com.bumptech.glide.disklrucache"

    defaultConfig {
        minSdk = libs.versions.min.sdk.version.get().toInt()
        targetSdk = libs.versions.target.sdk.version.get().toInt()

        compileSdk = 34

        // versionName VERSION_NAME as String
        consumerProguardFiles("proguard-rules.txt")
    }

//    compileOptions {
//        sourceCompatibility JavaVersion.VERSION_1_8
//        targetCompatibility JavaVersion.VERSION_1_8
//    }
}

dependencies {
    testImplementation(libs.junit)
    testImplementation(libs.truth)
}

//def uploaderScript = "${rootProject.projectDir}/scripts/upload.gradle"
//if (file(uploaderScript).exists()) {
//	apply from: uploaderScript
//}
