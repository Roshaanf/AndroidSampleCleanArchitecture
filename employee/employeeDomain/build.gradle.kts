plugins {
    id("java-library")
    id("kotlin")
    kotlin("kapt")
}

dependencies {
    api(project(":base:baseDomain"))

    implementation(DevelopmentDependencies.kotlinStdLib)

//    dagger
    implementation(DevelopmentDependencies.dagger)
    kapt(DevelopmentDependencies.daggerCompiler)

    //    if jars are added manually in module/libs folder then below line will include them as depenency in project
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

