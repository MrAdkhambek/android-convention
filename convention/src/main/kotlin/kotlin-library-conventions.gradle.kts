import extension.implementationBundle
import gradle.kotlin.dsl.accessors._fba23a28a1c8af1776e6159a3fead7ea.java
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import extension.libraries as libs

plugins {
    id("org.jetbrains.kotlin.jvm")
}

tasks.named<KotlinJvmCompile>("compileKotlin") {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        optIn.add("kotlin.RequiresOptIn")
        freeCompilerArgs.addAll(
            "-Xjsr305=strict",
            "-Xexplicit-api=warning",
            "-Xcontext-parameters"
        )
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementationBundle(libs.findBundle("kotlin-core").get())
}
