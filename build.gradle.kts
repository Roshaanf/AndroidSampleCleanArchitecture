// Top-level build file where you can add configuration options common to all sub-projects/modules.

// buildscript block is only for dependencies required by gradle to build the project
buildscript {
    repositories {
//        gradle will fetch dependencies from here for itself to build project,dependencies declared
//        with classpath will be downloaded from below repositorie, dependencies for our project
//        required in source won't be downloaded from below repositories, we declare repositories
//        for our project dependencies in allProject block, if we fail to define repositories in allProject
//        gradle will be unable to fetch our code dependencies declared in app level build.gradle
        google()
        jcenter()

    }
    dependencies {
//        classpath is used when buildscript/gradle needs dependencies, when our project need dependencies we use implementation
        classpath( GradleDependencies.androidGradleTools)
        classpath (GradleDependencies.kotlinGradlePlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

//if we change subProjects with allProjects printProjectName task will print 4 statements
//currently it is printing 3 statements
subprojects {
//    gradle fetches our code dependencies declared in app level build.gradle with impementation config
//    from below repositories, e.g retrofit, room and other libraries, comment below repositories and error
//    will come up
    repositories {
        google()
        jcenter()

    }

//    allProjects block runs for each module uncomment below task and run it to print project names,
//    changing project.name to rootProject.name will print AndroidSampleCleanArchitecture
//    task printProjName << {
//        println ">> " + project.name
//    }

//    we dont declare dependencies block here because each module will define its dependencies in its
//    build.gradle

}


tasks.register("clean").configure {
    delete("build")
}
