plugins {
    java
    id("com.gradleup.shadow") version "9.0.0-beta12"
}

group = "me.pulsi_"
version = "6.5-Alpha3"

repositories {
    mavenCentral()

    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }

    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }

    maven("https://repo.essentialsx.net/releases/") {
        name = "essentialsx-releases"
    }

    maven("https://jitpack.io")

    maven("https://repo.tcoded.com/releases") {
        name = "tcoded-releases"
    }

    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/") {
        name = "placeholderapi"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7.1")
    compileOnly("me.clip:placeholderapi:2.11.7")

    compileOnly(
        fileTree("libs") {
            include("*.jar")
        }
    )
    implementation("net.essentialsx:EssentialsX:2.21.0")
    {
        exclude("org.spigotmc")
    }

    implementation("com.tcoded:FoliaLib:0.5.1")
    implementation("org.xerial:sqlite-jdbc:3.46.0.0")
}

val targetJavaVersion = 21

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(targetJavaVersion))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
        options.release.set(targetJavaVersion)
    }

tasks.processResources {
    inputs.property("version", project.version)
    filteringCharset = "UTF-8"

    filesMatching("plugin.yml") {
        expand("version" to project.version)
    }
    }

tasks.shadowJar {
    relocate(
        "com.tcoded.folialib",
        "${project.group}.${project.name.lowercase()}.lib.folialib"
    )

    archiveClassifier.set("")
}

tasks.jar {
    enabled = false
}
