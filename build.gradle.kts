plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    `java-library`

    //For publishing contracts to Pact Broker
    id("au.com.dius.pact") version "4.2.21" //The same as "pactVersion"
}

val pactVersion = "4.2.21"

repositories {
    mavenCentral()
}

pact {
    publish {
        //pactDirectory = "$buildDir/pacts"
        pactBrokerUrl="http://localhost:9292"
        //pactBrokerUsername = "mybrokerUser"
        //pactBrokerPassword = "mybrokerPassword"
    }
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


    implementation("com.jcabi:jcabi-http:1.20.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")


    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation("org.assertj:assertj-core:3.23.1")

    //pact 4 junit dep
    testImplementation("au.com.dius.pact.consumer:junit5:$pactVersion")
}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}
