package com.shn.jetpacktest.basic.webview;

import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.shn.jetpacktest.MyApplication;

public class WebViewPoolManager {
  private static final WebViewPoolManager INSTANCE = new WebViewPoolManager();

  private WebView mWebView;

  public static WebViewPoolManager getInstance() {
    return INSTANCE;
  }

  public WebView getWebView() {
    return mWebView;
  }

  private WebViewPoolManager() {
    mWebView = new WebView(MyApplication.instance.getInstance());
    ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT);
    mWebView.setLayoutParams(params);
    mWebView.loadUrl("https://blog.csdn.net/qq_33721320/article/details/84400825");
  }

}
