plugins {
    java
    application
    kotlin("jvm") version "1.9.23"
}

application {
    // NOTE: In case you choose a different main class, make sure to update this path
    mainClass = "KotlinApplicationKt"
    // mainClass = "JavaApplication"
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClass
    }

    from(configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) })
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.23")
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
