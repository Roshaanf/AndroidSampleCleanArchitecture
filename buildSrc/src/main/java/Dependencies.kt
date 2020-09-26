object AppConfiguration {
    val androidCompileSdkVersion = 28
    val androidMinSdkVersion = 21
    val androidTargetSdkVersion = 28
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val kotlin_version = "1.3.50"
    val retrofit_version = "2.6.2"
    val okhttp_logging_interceptor_version = "3.12.1"
    val constraint_layout_version = "2.0.0-alpha2"
    val lifecycle_version = "2.2.0"
    val junit_version = "4.12"
    val appcompat_version = "1.2.0"
    val ktx_core_version = "1.3.1"
    val coroutine_version = "1.3.5"
    val room_version = "2.1.0-alpha04"
    val dagger_version = "2.29.1"
    val glide_version = "4.11.0"
    val recyclerview_version = "1.0.0"
}

object GradleDependencies {
    val androidGradleTools = "com.android.tools.build:gradle:4.0.0"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
}

object DevelopmentDependencies {

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    val ktxCore = "androidx.core:core-ktx:${Versions.ktx_core_version}"
    val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
    val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0-beta01"

    //    viewmodel ktx for viewmodelScope etc
    val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
//    val liveData = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle_version}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
    val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging_interceptor_version}"

    //   this dependecy contains coroutines also Dispatcher.Main which is specialized for android
    val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine_version}"

    //    this dependency wont include android side, so adding core dependency for only domain module
//  as we don't want out domain to have android dependency
    val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine_version}"
    val roomRuntime = "androidx.room:room-runtime:${Versions.room_version}"
    val roomCoroutine = "androidx.room:room-coroutines:${Versions.room_version}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room_version}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"

    val dagger = "com.google.dagger:dagger:${Versions.dagger_version}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger_version}"

    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview_version}"
}


object TestDependencies {
    val junit = "junit:junit:4.12"
}

object AndroidTestDependencies {
    val testRunner = "androidx.test:runner:1.1.0-alpha4"
    val espresseo = "androidx.test.espresso:espresso-core:3.1.0-alpha4"

}
