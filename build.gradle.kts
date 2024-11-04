plugins {
    kotlin("jvm") version "1.9.25"
    application
}

group = "d.mikh.test"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

val kotlinJdkVersion: String by project

kotlin {
    jvmToolchain(kotlinJdkVersion.toInt())
}

repositories {
    mavenCentral()
}


dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}