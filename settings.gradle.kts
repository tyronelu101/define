pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Define"
include(":app")

include("core:data")
include(":core:database")
include(":core:datastore")
include(":core:datastore-proto")

include(":core:domain")
include(":core:models")
include(":core:network")
include(":core:ui")

include(":feature:dictionary")
include(":feature:setup")
include(":feature:settings")
include(":feature:words")

