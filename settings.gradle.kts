dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libraries") { from(files("gradle/libraries.versions.toml")) }
    }
}

include(":convention")