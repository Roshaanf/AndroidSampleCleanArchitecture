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

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":base:baseDomain"))
    implementation(project(":base:baseData"))

    implementation(DevelopmentDependencies.kotlinStdLib)

    implementation(DevelopmentDependencies.ktxCore)

    implementation(DevelopmentDependencies.viewModelKtx)

    implementation(DevelopmentDependencies.appCompat)

    //    glide
    implementation(DevelopmentDependencies.glide)

    implementation(DevelopmentDependencies.recyclerView)

    //    dagger
    implementation(DevelopmentDependencies.dagger)
    kapt(DevelopmentDependencies.daggerCompiler)

    testImplementation(TestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.testRunner)
    androidTestImplementation(AndroidTestDependencies.espresseo)

}