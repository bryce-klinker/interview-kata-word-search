plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.3.41"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

repositories {
    jcenter()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    testImplementation("io.cucumber:cucumber-java8:4.7.1")

    testImplementation("io.cucumber:cucumber-junit:4.7.1")

    testImplementation("org.hamcrest:hamcrest:2.1")
}

configurations.create("cucumberRuntime") {
    extendsFrom(configurations["testImplementation"])
}

tasks.create("cucumber") {
    dependsOn("assemble", "compileTestKotlin")
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations["cucumberRuntime"] + sourceSets["main"].output + sourceSets["test"].output
            args("--plugin", "pretty", "--glue", "kata.word.search.atdd", "src/test/resources")
        }
    }
}