plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(DevelopmentDependencies.kotlinStdLib)
    implementation(DevelopmentDependencies.retrofit)
    implementation(DevelopmentDependencies.retrofitGsonConverter)
    implementation(DevelopmentDependencies.coroutinesAndroid)
}

