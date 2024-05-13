# Convention Plugins (W.I.P)

[Original Project](https://github.com/raxden/android-convention).

The `build-logic` folder defines project-specific convention plugins, used to keep a single
source of truth for common module configurations.


## Basic setup

1. Navigate to Your Project's Root Directory
2. Add the Repository as a Submodule:

```
git submodule add git@github.com:MrAdkhambek/android-convention.git
```
3. Change the name of the folder to build-logic
```
git mv android-convention build-logic
```
4. Modify your `settings.gradle.kts` setting the path of toml.
```
pluginManagement {
    includeBuild("build-logic")
    ...
}
...
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") { from(files("build-logic/gradle/libraries.versions.toml")) }
    }
    ...
}
```

## Plugins

#### Android application

<details open><summary>Kotlin</summary>

```kt
plugins {
    id("android-application-conventions")
}
```

</details>

<details><summary>Groovy</summary>

```groovy
plugins {
    id 'android-application-conventions'
}
```

</details>

