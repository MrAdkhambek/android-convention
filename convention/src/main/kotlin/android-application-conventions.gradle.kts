import extension.findLibraryOrThrow
import extension.libraries
import extension.versions

plugins {
    id("com.android.application")
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

    signingConfigs {
        getByName("debug") {
            storeFile = project.file("${project.rootDir}/config/debug.keystore")
            storePassword = "android"
            keyAlias = "android.debug.key"
            keyPassword = "android"
        }
    }

    defaultConfig {
        minSdk = libraries.versions.minSdk
        targetSdk = libraries.versions.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName("debug")

            // Proguard configuration
            isMinifyEnabled = false

            // Tests configuration
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }
    }

    packaging {
        resources {
            excludes.add("META-INF/LICENSE.md")
            excludes.add("META-INF/LICENSE-notice.md")
            excludes.add("META-INF/*.kotlin_module")
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
