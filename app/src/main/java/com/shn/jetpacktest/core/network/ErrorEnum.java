package com.shn.jetpacktest.core.network;

import com.tencent.bugly.crashreport.CrashReport;

import java.util.regex.Pattern;

public enum ErrorEnum {
  ERROR_AUTH_IP_BE_BANED("登录受限", "登录受限"),
  ;

  private String pattern;
  private String readable;

  ErrorEnum(String pattern, String readable) {
    this.pattern = pattern;
    this.readable = readable;
  }

  public String getPattern() {
    return pattern;
  }

  public String getReadable() {
    return readable;
  }

  public void check(String src) throws VException {
    if (readable.isEmpty()) {
      String error = HtmlUtil.matcherGroup1(Pattern.compile(pattern), src);
      if (error.isEmpty()) return;
      VException vException = new VException(error);
//      Logger.e(src);
      vException.setReference(src);
      throw vException;
    }
    if (src.contains(pattern)) {
      throw new VException(readable);
    }
  }

  public void throwThis() throws VException {
    VException vException = new VException(readable);
    CrashReport.postCatchedException(vException);
    throw vException;
  }
}
