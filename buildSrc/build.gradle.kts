
plugins{
//    this plugin allows to use kotlin for gradle buildscripts this file has .kts which tells
//    gradle that this is written in kotlin-dsl and not in groovy
    `kotlin-dsl`
}

repositories {
    jcenter() // this is needed to download dependencies for kotlin-dsl
}