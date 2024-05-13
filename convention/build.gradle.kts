/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

group = "com.adkhambek.build-logic.convention"

java {
    sourceCompatibility = JavaVersion.toVersion(libraries.versions.sourceCompatibility.get())
    targetCompatibility = JavaVersion.toVersion(libraries.versions.targetCompatibility.get())
}

dependencies {
    implementation(libraries.android.gradlePlugin)
    implementation(libraries.kotlin.gradlePlugin)
}