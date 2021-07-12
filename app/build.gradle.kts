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
  implementation(Dependencies.framework.kotlin_std)
  implementation(Dependencies.framework.coreKtx)

  implementation(Dependencies.framework.androidx.appcompat)
  implementation(Dependencies.framework.androidx.constrainLayout)
  implementation(Dependencies.framework.androidx.recyclerview)
  implementation(Dependencies.framework.androidx.navigationFragment)
  implementation(Dependencies.framework.androidx.navigationUi)
  implementation(Dependencies.framework.androidx.navigationFragmentKtx)
  implementation(Dependencies.framework.androidx.navigationUiKtx)
  implementation(Dependencies.framework.androidx.lifecycleExtensions)

  implementation(Dependencies.framework.image.fresco)
  implementation(Dependencies.framework.image.frescoAnimatedBaseSupport)
  implementation(Dependencies.framework.image.frescoAnimatedGif)
  implementation(Dependencies.framework.image.frescoAnimatedWebp)
  implementation(Dependencies.framework.image.frescoWebpSupport)

  implementation(Dependencies.framework.hilt.hilt)
  kapt(Dependencies.framework.hilt.hiltCompiler)

  implementation(Dependencies.framework.rxandroid.rxandroid)
  implementation(Dependencies.framework.rxandroid.rxjava)

  implementation(Dependencies.framework.network.okhttp)
  implementation(Dependencies.framework.network.okhttp_interceptor)
  implementation(Dependencies.framework.network.retrofit)
  implementation(Dependencies.framework.network.retrofit_gson)
  implementation(Dependencies.framework.network.retrofit_adapter)

  implementation(Dependencies.library.thirdParty.mmkv)

  debugImplementation(Dependencies.framework.leakcanary)

//    implementation ''
//    implementation 'com.google.android.material:material:1.0.0'
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

}