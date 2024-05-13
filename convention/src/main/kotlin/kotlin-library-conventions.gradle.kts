import extension.implementationBundle
import extension.libraries as libs
import extension.versions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("kotlin-jvm")
}

tasks.withType(KotlinCompile::class).all {
    kotlinOptions.jvmTarget = libs.versions.jdk.toString()
}

tasks.withType(JavaCompile::class).all {
    sourceCompatibility = libs.versions.sourceCompatibility.toString()
    targetCompatibility = libs.versions.targetCompatibility.toString()
}

dependencies {
    implementationBundle(libs.findBundle("kotlin-core").get())
}
