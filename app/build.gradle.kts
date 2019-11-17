
plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}


android{

    compileSdkVersion(AppConfiguration.androidCompileSdkVersion)

    defaultConfig {
        applicationId = "com.samplecleanarchitecture"
        minSdkVersion(AppConfiguration.androidMinSdkVersion)
        targetSdkVersion(AppConfiguration.androidTargetSdkVersion)
        versionCode= AppConfiguration.versionCode
        versionName =AppConfiguration.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    dataBinding {
        isEnabled =true
    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data"))

//    if jars are added manually in module/libs folder then below line will include them as depenency in project
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(DevelopmentDependencies.kotlinStdLib)
    implementation(DevelopmentDependencies.appCompat)

    implementation(DevelopmentDependencies.ktxCore)
    implementation(DevelopmentDependencies.constraintLayout)
    implementation(DevelopmentDependencies.legacySupport)

    //    lifecycle
    implementation(DevelopmentDependencies.lifecycle)


    //    retrofit
    implementation(DevelopmentDependencies.retrofit)
    implementation(DevelopmentDependencies.retrofitGsonConverter)
//    coroutine adapter
    implementation(DevelopmentDependencies.kotlinRetrofitCoroutineAdapter)

//    coroutines
    implementation(DevelopmentDependencies.coroutinesAndroid)

//    room
    implementation(DevelopmentDependencies.roomRuntime)
    implementation(DevelopmentDependencies.roomCoroutine)
    kapt(DevelopmentDependencies.roomCompiler)

    testImplementation(TestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.testRunner)
    androidTestImplementation(AndroidTestDependencies.espresseo)
}
