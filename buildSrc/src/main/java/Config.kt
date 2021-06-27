private const val androidGradleVersion = "4.0.0"


// Unit tests
private const val mockitoVersion = "2.13.0"

object Config {
    object Version {
        val kotlinVersion = "1.3.72"
    }

    object BuildPlugins {
        val androidGradle = "com.android.tools.build:gradle:$androidGradleVersion"
        val kotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
    }

    object Android {
        val buildToolsVersion = "30.0.3"
        val minSdkVersion = 21
        val targetSdkVersion = 30
        val compileSdkVersion = 30
        val applicationId = "com.antonioleiva.bandhookkotlin"
        val versionCode = 1
        val versionName = "0.1"

    }

}