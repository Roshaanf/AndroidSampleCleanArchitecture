plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}


android {

    compileSdkVersion(AppConfiguration.androidCompileSdkVersion)

    defaultConfig {
        applicationId = "com.samplecleanarchitecture"
        minSdkVersion(AppConfiguration.androidMinSdkVersion)
        targetSdkVersion(AppConfiguration.androidTargetSdkVersion)
        versionCode = AppConfiguration.versionCode
        versionName = AppConfiguration.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            //            minify enabled will reduce the size of apk by removing unused code
//            when set to true for each build it generates decode key which is
//            stored in build/outs in mappings.txt , make sure to save that key before
//            uploading build because minifyenabled makes code jumble and you wont be
//            able to read stacktrace correctly
//            set also shrinkResources to true when setting minifyEnabled true
//            minify enabled works on java side and shrink resources works for resources(res) side

            isShrinkResources = false
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }


    }
    dataBinding {
        isEnabled = true
    }
}

dependencies {

    implementation(project(":base:basePresentation"))
//   so Application can access basedataapplocatoom
    implementation(project(":base:baseData"))
    implementation(project(":employee:employeePresentation"))
    implementation(project(":about:aboutPresentation"))

//    if jars are added manually in module/libs folder then below line will include them as depenency in project
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(DevelopmentDependencies.appCompat)
    implementation(DevelopmentDependencies.ktxCore)
    implementation(DevelopmentDependencies.constraintLayout)
    implementation(DevelopmentDependencies.legacySupport)

    testImplementation(TestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.testRunner)
    androidTestImplementation(AndroidTestDependencies.espresseo)
}
