plugins {
    id("com.android.library")
//    if android kotlin plugin is removed then dependenct module will throw unresolved class while building
    kotlin("android")
    kotlin("android.extensions")
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
    implementation(project(":base:baseData"))
    implementation(project(":about:aboutDomain"))
    //    if jars are added manually in module/libs folder then below line will include them as depenency in project
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(DevelopmentDependencies.kotlinStdLib)

    //    dagger
    implementation(DevelopmentDependencies.dagger)
    kapt(DevelopmentDependencies.daggerCompiler)

    testImplementation(TestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.testRunner)
    androidTestImplementation(AndroidTestDependencies.espresseo)

}