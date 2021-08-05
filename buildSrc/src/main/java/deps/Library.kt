package deps

class Library {
  val thirdParty = ThirdParty()
  val bugly = Bugly()

  inner class ThirdParty {
    val mmkv = "com.tencent:mmkv-static:1.2.10"
    val utilcodex = "com.blankj:utilcodex:1.30.6"
    val jsoup = "org.jsoup:jsoup:1.14.1"
  }

  inner class Bugly {
    val sdk = "com.tencent.bugly:crashreport:3.3.9"
    val ndk = "com.tencent.bugly:nativecrashreport:3.9.0"
  }
}