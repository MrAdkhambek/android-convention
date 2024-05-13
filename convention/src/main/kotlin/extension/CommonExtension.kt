package extension

import org.gradle.api.Project
import java.util.Properties

internal fun Project.getSigningConfigProperties(buildType: String): Properties {
    val properties = Properties()
    val propertiesFile = file("$rootDir/config/signing_$buildType.properties")
    if (propertiesFile.exists()) {
        propertiesFile.inputStream().use(properties::load)
    } else {
        println("No signing config found for build type $buildType")
    }
    return properties
}
