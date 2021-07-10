package com.shn.jetpacktest.core.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.shn.jetpacktest.R;
import com.shn.jetpacktest.basic.webview.WebViewPoolManager;

public class WebViewActivity extends AppCompatActivity {
  private ViewGroup mRootView;
  private WebView mWebView;

  public static void open(Activity activity) {
    Intent intent = new Intent(activity, WebViewActivity.class);
    activity.startActivity(intent);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_webview);
  }

  @Override
  protected void onResume() {
    super.onResume();
    mRootView = findViewById(R.id.root);
    mWebView = WebViewPoolManager.getInstance().getWebView();
    mRootView.addView(mWebView);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mRootView.removeView(mWebView);
  }

}
