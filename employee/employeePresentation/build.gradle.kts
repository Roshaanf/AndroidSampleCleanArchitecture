plugins {
    id("com.android.library")
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

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(project(":base:basePresentation"))
    implementation(project(":item:itemDomain"))
    implementation(project(":item:itemData"))

    //    if jars are added manually in module/libs folder then below line will include them as depenency in project
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(DevelopmentDependencies.kotlinStdLib)


    implementation(DevelopmentDependencies.appCompat)
    implementation(DevelopmentDependencies.ktxCore)
    implementation(DevelopmentDependencies.constraintLayout)
    implementation(DevelopmentDependencies.legacySupport)

    //    lifecycle
    implementation(DevelopmentDependencies.viewModelKtx)

    testImplementation(TestDependencies.junit)
    androidTestImplementation(AndroidTestDependencies.testRunner)
    androidTestImplementation(AndroidTestDependencies.espresseo)
}
