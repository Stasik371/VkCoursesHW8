plugins {
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("org.flywaydb:flyway-core:9.8.1")
    implementation(project(":jooq-generated"))
    implementation("org.jetbrains:annotations:23.0.0")

    implementation("org.eclipse.jetty:jetty-server:9.4.33.v20201020")
    implementation("org.eclipse.jetty:jetty-servlet:9.4.33.v20201020")
    implementation("org.eclipse.jetty:jetty-client:9.4.33.v20201020")
    implementation("org.eclipse.jetty:jetty-servlets:9.4.33.v20201020")

    implementation("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.22")

    implementation("com.google.inject:guice:5.1.0")
    implementation("com.google.inject.extensions:guice-servlet:5.1.0")

    implementation("org.jboss.resteasy:resteasy-guice:4.7.7.Final")
    implementation("org.jboss.resteasy:resteasy-jackson-provider:4.0.0.Beta5")
    implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}