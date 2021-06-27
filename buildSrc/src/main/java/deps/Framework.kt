package deps

import Config


class Framework {
    val kotlin_std = "org.jetbrains.kotlin:kotlin-stdlib:${Config.Version.kotlinVersion}"
    val coreKtx = "androidx.core:core-ktx:1.5.0"

    val androidx = Androidx()
    val network = Network()
    val image = Image()

    inner class Network {
        val okhttp = "com.squareup.okhttp3:okhttp:3.9.1"
        val okhttp_interceptor = "com.squareup.okhttp3:logging-interceptor:3.9.1"
        val retrofit = "com.squareup.retrofit2:retrofit:2.3.0"
        val retrofit_gson = "com.squareup.retrofit2:converter-gson:2.3.0"
    }

    inner class Image {
        private val frescoVersion = "0.12.0"
        val fresco = "com.facebook.fresco:fresco:$frescoVersion"

        // 在 API < 14 上的机器支持 WebP 时，需要添加
        val frescoAnimatedBaseSupport = "com.facebook.fresco:animated-base-support:$frescoVersion"

        // 支持 GIF 动图，需要添加
        val frescoAnimatedGif = "com.facebook.fresco:animated-gif:$frescoVersion"

        // 支持 WebP （静态图+动图），需要添加
        val frescoAnimatedWebp = "com.facebook.fresco:animated-webp:$frescoVersion"
        val frescoWebpSupport = "com.facebook.fresco:webpsupport:$frescoVersion"// 仅支持 WebP 静态图，需要添加
    }

    inner class Androidx {
        val appcompat = "androidx.appcompat:appcompat:1.2.0"
        val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"
        val constrainLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        val navigationFragment = "androidx.navigation:navigation-fragment:2.1.0"
        val navigationUi = "androidx.navigation:navigation-ui:2.1.0"
        val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.1.0"
        val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:2.1.0"
        val material = "com.google.android.material:material:1.0.0"
        val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.1.0"
    }

}