package com.shn.jetpacktest

import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import com.shn.jetpacktest.basic.network.RetrofitManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

  companion object instance {
    private lateinit var mContext: Context

    fun getInstance(): Context {
      return mContext
    }
  }


  override fun onCreate() {
    super.onCreate()
    Fresco.initialize(this)
    mContext = getApplicationContext();
    RetrofitManager.init(mContext)
  }

}