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

    buildTypes {
        getByName("debug") {
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
//            excludes.add("META-INF/*.kotlin_module")
        }
    }

    project.kotlin {
        jvmToolchain(jdkVersion = libraries.versions.jdk.asInt())
    }

    kotlinOptions {
        jvmTarget = libraries.versions.jdk.toString()
        freeCompilerArgs += listOf(
            "-Xjsr305=strict",
            "-Xexplicit-api=warning",
            "-Xcontext-receivers"
        )
    }

    dependencies {
        add("coreLibraryDesugaring", libraries.findLibrary("coreLibraryDesugaring").get())
    }
}
