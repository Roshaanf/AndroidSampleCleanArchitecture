plugins {
    id("java-library")
    id("kotlin")
    kotlin("kapt")
}

dependencies {
    //    if jars are added manually in module/libs folder then below line will include them as depenency in project
    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    api(DevelopmentDependencies.kotlinStdLib)
    api(DevelopmentDependencies.coroutines)

    api(DevelopmentDependencies.dagger)
    kapt(DevelopmentDependencies.daggerCompiler)
}

