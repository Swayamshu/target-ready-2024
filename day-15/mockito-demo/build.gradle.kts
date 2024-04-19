plugins {
    kotlin("jvm") version "1.9.22"
}

group = "com.targetindia"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.11.0")
    compileOnly("org.projectlombok:lombok:1.18.32")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}