plugins {
    id("java-library")
    id("kotlin")
    kotlin("kapt")
}

dependencies {
    //    if jars are added manually in module/libs folder then below line will include them as depenency in project
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(DevelopmentDependencies.kotlinStdLib)
    implementation(DevelopmentDependencies.coroutines)

    implementation(DevelopmentDependencies.dagger)
    kapt(DevelopmentDependencies.daggerCompiler)
}

