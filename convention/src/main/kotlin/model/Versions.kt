package model

import extension.findVersionOrThrow
import org.gradle.api.JavaVersion
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.jvm.toolchain.JavaLanguageVersion

class Versions private constructor(
    val minSdk: Int,
    val compileSdk: Int,
    val targetSdk: Int,
    val jdk: JavaLanguageVersion,
    val sourceCompatibility: JavaVersion,
    val targetCompatibility: JavaVersion,
) {
    constructor(catalog: VersionCatalog) : this(
        minSdk = catalog.findVersionOrThrow("minSdk").toInt(),
        compileSdk = catalog.findVersionOrThrow("compileSdk").toInt(),
        targetSdk = catalog.findVersionOrThrow("targetSdk").toInt(),
        jdk = JavaLanguageVersion.of(catalog.findVersionOrThrow("jdk")),
        targetCompatibility = JavaVersion.toVersion(catalog.findVersionOrThrow("targetCompatibility")),
        sourceCompatibility = JavaVersion.toVersion(catalog.findVersionOrThrow("sourceCompatibility")),
    )
}