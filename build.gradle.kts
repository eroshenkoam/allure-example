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
    version = "2.9.0"

    useJUnit5 {
        version = "2.9.0"
    }

}

tasks.withType(JavaCompile::class) {
    sourceCompatibility = "${JavaVersion.VERSION_1_8}"
    targetCompatibility = "${JavaVersion.VERSION_1_8}"
    options.encoding = "UTF-8"
}

tasks.withType(Test::class) {
    useJUnitPlatform {

    }
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "dynamic")
}


repositories {
    maven("https://dl.bintray.com/qameta/maven")
    mavenCentral()
}

dependencies {
    compile("io.qameta.allure:allure-java-commons:2.9.0")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.0")
    testCompile("org.junit.jupiter:junit-jupiter-engine:5.3.0")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.3.0")
}
