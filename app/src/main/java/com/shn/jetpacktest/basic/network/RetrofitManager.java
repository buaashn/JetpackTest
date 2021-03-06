package com.shn.jetpacktest.basic.network;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitManager {
  private static final long READ_TIMEOUT = 15000L;
  private static final long WRITE_TIMEOUT = 15000L;
  private static final long CONNECT_TIMEOUT = 15000L;
  private static final String BASE_URL = "http://www.v2ex.com/";

  private static Retrofit retrofit;

  public static void init(@Nonnull Context context) {
    Gson gson = new GsonBuilder()
      .serializeNulls()
      .disableHtmlEscaping()
      .setPrettyPrinting()
      .setDateFormat("MM-dd HH:mm")
      .setLenient()
      .create();
    OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
      .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
      .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
      .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);


    Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create(gson))
      .addConverterFactory(ScalarsConverterFactory.create())
      .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
      .client(okHttpClientBuilder.build())
      .callFactory(okHttpClientBuilder.build());
    retrofit = retrofitBuilder.build();
  }

  public static <T> T create(Class<T> tClass) {
    if (retrofit == null) {
      throw new IllegalStateException("Retrofit need be init, call RetrofitManager.init(Context) first.");
    }
    return retrofit.create(tClass);
  }
}
