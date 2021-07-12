package deps

class Library {
  val thirdParty = ThirdParty()

  inner class ThirdParty {
    val mmkv = "com.tencent:mmkv-static:1.2.10"
  }
}