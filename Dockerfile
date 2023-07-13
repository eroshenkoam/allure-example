FROM openjdk:8

COPY gradle /app/gradle
COPY src /app/src
COPY build.gradle.kts /app/build.gradle.kts
COPY gradlew /app/gradlew
COPY settings.gradle /app/settings.gradle

WORKDIR /app