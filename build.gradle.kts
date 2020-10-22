import io.qameta.allure.gradle.AllureExtension

buildscript {
    repositories {
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("io.qameta.allure:allure-gradle:2.6.0")
    }
}

tasks.existing(Wrapper::class) {
    gradleVersion = "4.10.2"
    distributionType = Wrapper.DistributionType.ALL
}

group = "io.eroshenkoam"
version = version

plugins {
    java
    maven
}

apply(plugin = "io.qameta.allure")

configure<AllureExtension> {
    autoconfigure = true
    aspectjweaver = true
    version = "2.12.1"

    useJUnit5 {
        version = "2.12.1"
    }

}

tasks.withType(JavaCompile::class) {
    sourceCompatibility = "${JavaVersion.VERSION_1_8}"
    targetCompatibility = "${JavaVersion.VERSION_1_8}"
    options.encoding = "UTF-8"
}

tasks.withType(Test::class) {
    ignoreFailures = true
    useJUnitPlatform {

    }
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "dynamic")

    systemProperty("junit.jupiter.extensions.autodetection.enabled", "true")
}


repositories {
    maven(url = "https://dl.bintray.com/qameta/maven-unstable/")
    mavenCentral()
    mavenLocal()
}

dependencies {
    compile("commons-io:commons-io:2.6")
    compile("io.qameta.allure:allure-java-commons:2.12.1")
    compile("org.junit.jupiter:junit-jupiter-api:5.3.0")
    compile("org.junit.jupiter:junit-jupiter-engine:5.3.0")
    compile("org.junit.jupiter:junit-jupiter-params:5.3.0")

    testCompile("io.qameta.allure:allure-ee-junit-platform:3.28.2")
}
