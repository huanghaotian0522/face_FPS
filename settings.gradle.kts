pluginManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/public")
        google()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven("https://maven.aliyun.com/repository/google")
        mavenCentral()
    }
}