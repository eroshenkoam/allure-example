group = "io.eroshenkoam.allure"
version = version

plugins {
    java
    id("io.qameta.allure") version "2.9.1"
}

allure {
    report {
        version.set("2.14.0")
    }
    adapter {
        autoconfigure.set(true)
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.14.0")
            }
        }
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
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("commons-io:commons-io:2.6")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.5")
    implementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    implementation("org.junit.jupiter:junit-jupiter-params:5.7.2")
}
