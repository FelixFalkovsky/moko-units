/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

pluginManagement {
    repositories {
        mavenLocal()

        jcenter()
        google()

        maven { url = uri("https://dl.bintray.com/kotlin/kotlin") }
        maven { url = uri("https://kotlin.bintray.com/kotlinx") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://dl.bintray.com/icerockdev/plugins") }
    }
    resolutionStrategy.eachPlugin {
        val module = Deps.plugins[requested.id.id] ?: return@eachPlugin

        useModule(module)
    }
}

enableFeaturePreview("GRADLE_METADATA")

val properties = startParameter.projectProperties

// ./gradlew -PpluginPublish publishPluginPublicationToMavenLocal
// ./gradlew -PlibraryPublish publishToMavenLocal
val libraryPublish: Boolean = properties.containsKey("libraryPublish")

include(":gradle-plugin")
include(":units")

if (!libraryPublish) {
    include(":sample:android-app")
    include(":sample:mpp-library")
}
