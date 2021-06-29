plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
  id("dagger.hilt.android.plugin")
}

android {
  compileSdkVersion(Config.Android.compileSdkVersion)
  buildToolsVersion(Config.Android.buildToolsVersion)

  defaultConfig {
    applicationId = Config.Android.applicationId
    minSdkVersion(Config.Android.minSdkVersion)
    targetSdkVersion(Config.Android.targetSdkVersion)
    versionCode = Config.Android.versionCode
    versionName = Config.Android.versionName

    testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles("proguard-rules.pro")
    }
    getByName("debug") {
      isDebuggable = true
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_1_8.toString()
  }
}


dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
  implementation(Dependencies.framwork.kotlin_std)
  implementation(Dependencies.framwork.coreKtx)

  implementation(Dependencies.framwork.androidx.appcompat)
  implementation(Dependencies.framwork.androidx.constrainLayout)
  implementation(Dependencies.framwork.androidx.recyclerview)
  implementation(Dependencies.framwork.androidx.navigationFragment)
  implementation(Dependencies.framwork.androidx.navigationUi)
  implementation(Dependencies.framwork.androidx.navigationFragmentKtx)
  implementation(Dependencies.framwork.androidx.navigationUiKtx)
  implementation(Dependencies.framwork.androidx.lifecycleExtensions)

  implementation(Dependencies.framwork.image.fresco)
  implementation(Dependencies.framwork.image.frescoAnimatedBaseSupport)
  implementation(Dependencies.framwork.image.frescoAnimatedGif)
  implementation(Dependencies.framwork.image.frescoAnimatedWebp)
  implementation(Dependencies.framwork.image.frescoWebpSupport)

  implementation(Dependencies.framwork.hilt.hilt)
  kapt(Dependencies.framwork.hilt.hiltCompiler)

  implementation(Dependencies.framwork.rxandroid.rxandroid)
  implementation(Dependencies.framwork.rxandroid.rxjava)

//    implementation ''
//    implementation 'com.google.android.material:material:1.0.0'
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

}