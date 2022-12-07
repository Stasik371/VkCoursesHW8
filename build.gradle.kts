plugins {
    java
    `kotlin-dsl`
    application
    id("nu.studer.jooq") version "8.0" apply false
}

group = "org.example"
version = "1.0-SNAPSHOT"
allprojects {
    repositories {
        mavenCentral()
        google()
    }
}
dependencies {
    implementation("javax.servlet:javax.servlet-api:4.0.1")
}
subprojects {
    apply {
        plugin("nu.studer.jooq")
        plugin("org.jetbrains.kotlin.jvm")
    }

    dependencies {

        implementation("com.fasterxml.jackson.core:jackson-core:2.14.1")

        implementation("org.postgresql:postgresql:42.5.0")
        implementation("org.jooq:jooq:3.17.5")
        implementation("org.jooq:jooq-codegen:3.17.5")
        implementation("org.jooq:jooq-meta:3.17.5")

        implementation("com.google.inject:guice:5.1.0")
        implementation("com.google.inject.extensions:guice-servlet:5.1.0")
        implementation("org.jboss.resteasy:resteasy-guice:4.7.7.Final")
        implementation("org.jboss.resteasy:resteasy-jackson-provider:4.0.0.Beta5")
        implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")

        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    }


    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }
}