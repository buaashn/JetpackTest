package com.shn.jetpacktest.basic.mmkv;


import com.tencent.mmkv.MMKV;

public class MMKVManager {
  private static final MMKVManager INSTANCE = new MMKVManager();

  public static MMKVManager getInstance() {
    return INSTANCE;
  }

  public static void encode(String key, String value) {
    MMKV mmkv = MMKV.defaultMMKV();
    mmkv.encode(key, value);
  }

  public static String decode(String key) {
    MMKV mmkv = MMKV.defaultMMKV();
    return mmkv.decodeString(key, "");
  }

}
