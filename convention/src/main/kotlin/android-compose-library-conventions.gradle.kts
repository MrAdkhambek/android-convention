import extension.findLibraryOrThrow
import extension.libraries
import extension.versions
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

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

    tasks.withType<KotlinJvmCompile>().configureEach {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
            freeCompilerArgs.addAll(
                "-Xjsr305=strict",
                "-Xexplicit-api=warning",
                "-Xcontext-parameters"
            )
        }
    }

    dependencies {
        add("coreLibraryDesugaring", libraries.findLibraryOrThrow("coreLibraryDesugaring").get())
    }
}
