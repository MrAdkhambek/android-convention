import extension.findLibraryOrThrow
import extension.libraries
import extension.versions

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
}

android {

    compileSdk = libraries.versions.compileSdk

    compileOptions {
        sourceCompatibility = libraries.versions.sourceCompatibility
        targetCompatibility = libraries.versions.targetCompatibility
        isCoreLibraryDesugaringEnabled = true
    }

    defaultConfig {
        minSdk = libraries.versions.minSdk
        testOptions.targetSdk = libraries.versions.targetSdk // needed for instrumental tests
    }

    packaging {
        resources {
            excludes.add("META-INF/LICENSE.md")
            excludes.add("META-INF/LICENSE-notice.md")
//            excludes.add("META-INF/*.kotlin_module")
        }
    }

    project.kotlin {
        jvmToolchain(jdkVersion = libraries.versions.jdk.asInt())
    }

    kotlinOptions {
        jvmTarget = libraries.versions.jdk.toString()
    }

    dependencies {
        add("coreLibraryDesugaring", libraries.findLibraryOrThrow("coreLibraryDesugaring").get())
    }
}
