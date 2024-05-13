import extension.implementationBundle
import extension.libraries as libs
import extension.versions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm")
}

tasks.withType(KotlinCompile::class).all {
    kotlinOptions {
        jvmTarget = libs.versions.jdk.toString()
        freeCompilerArgs += listOf(
            "-Xjsr305=strict",
            "-Xexplicit-api=warning",
            "-Xcontext-receivers"
        )
    }
}

tasks.withType(JavaCompile::class).all {
    sourceCompatibility = libs.versions.sourceCompatibility.toString()
    targetCompatibility = libs.versions.targetCompatibility.toString()
}

dependencies {
    implementationBundle(libs.findBundle("kotlin-core").get())
}
