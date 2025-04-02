pluginManagement {
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

rootProject.name = "onshop"
include(":app")
include(":feature")

include(":core")
include(":core:ui")
include(":feature:login")
include(":core:model")
include(":core:common")
include(":feature:home")
include(":core:network")
include(":core:domain")
include(":feature:product_detail")
