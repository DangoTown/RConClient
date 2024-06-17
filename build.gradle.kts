plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("application")
}

group = "cn.rtast"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        name = "jitpack"
        url = uri("https://jitpack.io")
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.6")
    implementation("com.github.DangoTown:RCONLib:v1.0.1")
}

application {
    mainClass = "cn.rtast.rcc.RConClientKt"
}

tasks.build {
    dependsOn(tasks.shadowJar)
}

tasks.shadowJar {
    from("LICENSE")
}