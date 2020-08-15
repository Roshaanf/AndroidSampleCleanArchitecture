plugins {
    id("com.android.library")
//    if android kotlin plugin is removed then dependenct module will throw unresolved class while building
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfiguration.androidCompileSdkVersion)

    defaultConfig {
        minSdkVersion(AppConfiguration.androidMinSdkVersion)
        targetSdkVersion(AppConfiguration.androidTargetSdkVersion)
        versionCode = AppConfiguration.versionCode
        versionName = AppConfiguration.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

        }
    }
}

dependencies {
    //    if jars are added manually in module/libs folder then below line will include them as depenency in project
    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":basedomain"))

    api(DevelopmentDependencies.kotlinStdLib)

//    retrofit
    api(DevelopmentDependencies.retrofit)
    api(DevelopmentDependencies.retrofitGsonConverter)

    //    room
    api(DevelopmentDependencies.roomRuntime)
    api(DevelopmentDependencies.roomCoroutine)
    kapt(DevelopmentDependencies.roomCompiler)

    api(DevelopmentDependencies.dagger)
    kapt(DevelopmentDependencies.daggerCompiler)

    api("androidx.appcompat:appcompat:1.0.0-beta01")
    testImplementation(TestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.testRunner)
    androidTestImplementation(AndroidTestDependencies.espresseo)
}
