import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withGroovyBuilder
import java.io.File

pluginManager.apply("com.vanniktech.maven.publish")

fun prop(key: String): String? = if (hasProperty(key)) property(key)?.toString() else null

val groupId: String = prop("GROUP") ?: group.toString()
val artifactId: String = prop("POM_ARTIFACT_ID") ?: name
val versionName: String = prop("VERSION_NAME") ?: version.toString()
val publishVariant: String = prop("PUBLISH_VARIANT") ?: "release"
val isSnapshot: Boolean = versionName.endsWith("SNAPSHOT")

if (pluginManager.hasPlugin("com.android.library")) {
    extensions.findByName("android")?.withGroovyBuilder {
        "publishing" {
            "singleVariant"(publishVariant) {
                "withSourcesJar"()
                "withJavadocJar"()
            }
        }
    }
}

if (pluginManager.hasPlugin("java") || pluginManager.hasPlugin("java-library")) {
    extensions.configure(org.gradle.api.plugins.JavaPluginExtension::class.java) {
        withSourcesJar()
        withJavadocJar()
    }
}

extensions.findByName("mavenPublishing")?.withGroovyBuilder {
    val autoRelease = prop("MAVEN_CENTRAL_AUTO_RELEASE")?.toBoolean() ?: false
    val wantsCustomRepo = prop("LOCAL") != null ||
            prop("RELEASE_REPOSITORY_URL") != null ||
            prop("SNAPSHOT_REPOSITORY_URL") != null

    if (!wantsCustomRepo) {
        if (autoRelease) {
            "publishToMavenCentral"(mapOf("automaticRelease" to true))
        } else {
            "publishToMavenCentral"()
        }
    }

    if (!isSnapshot) {
        val hasSigning = hasProperty("signingInMemoryKey") ||
                hasProperty("signing.secretKeyRingFile") ||
                hasProperty("signing.keyId")
        if (hasSigning) {
            "signAllPublications"()
        }
    }

    "coordinates"(groupId, artifactId, versionName)

    "pom" {
        "name"(prop("POM_NAME") ?: project.name)
        "description"(prop("POM_DESCRIPTION") ?: "")
        prop("POM_INCEPTION_YEAR")?.let { "inceptionYear"(it) }
        "url"(prop("POM_URL") ?: "")

        "licenses" {
            "license" {
                "name"("Simplified BSD License")
                "url"("http://www.opensource.org/licenses/bsd-license")
                "distribution"("repo")
            }
            "license" {
                "name"("The Apache Software License, Version 2.0")
                "url"("http://www.apache.org/licenses/LICENSE-2.0.txt")
                "distribution"("repo")
            }
        }

        "developers" {
            "developer" {
                "id"(prop("POM_DEVELOPER_ID") ?: "")
                "name"(prop("POM_DEVELOPER_NAME") ?: "")
                "email"(prop("POM_DEVELOPER_EMAIL") ?: "")
            }
        }

        "scm" {
            "connection"(prop("POM_SCM_CONNECTION") ?: "")
            "developerConnection"(prop("POM_SCM_DEV_CONNECTION") ?: "")
            "url"(prop("POM_SCM_URL") ?: "")
        }
    }
}