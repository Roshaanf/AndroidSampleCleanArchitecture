object AppConfiguration {
    val androidCompileSdkVersion = 28
    val androidMinSdkVersion = 21
    val androidTargetSdkVersion = 28
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val kotlin_version = "1.3.20"
    val retrofit_version = "2.5.0"
    val constraint_layout_version = "2.0.0-alpha2"
    val junit_version = "4.12"
    val appcompat_version = "1.0.0-rc01"
    val ktx_core_version = "1.0.1"
    val coroutine_adapter_version = "0.9.2"
    val coroutine_version = "1.2.1"
    val room_version = "2.1.0-alpha04"
}

object GradleDependencies {
    val androidGradleTools = "com.android.tools.build:gradle:3.5.0"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
}

object DevelopmentDependencies {

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    val ktxCore = "androidx.core:core-ktx:${Versions.ktx_core_version}"
    val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
    val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0-beta01"
    val lifecycle = "androidx.lifecycle:lifecycle-extensions:2.0.0-rc01"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
    val kotlinRetrofitCoroutineAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutine_adapter_version}"
    val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine_version}"
    val roomRuntime = "androidx.room:room-runtime:${Versions.room_version}"
    val roomCoroutine = "androidx.room:room-coroutines:${Versions.room_version}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room_version}"

}


object TestDependencies {
    val junit = "junit:junit:4.12"
}

object AndroidTestDependencies {
    val testRunner = "androidx.test:runner:1.1.0-alpha4"
    val espresseo = "androidx.test.espresso:espresso-core:3.1.0-alpha4"

}
