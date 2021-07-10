package com.shn.jetpacktest.basic.network;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
  private static final long READ_TIMEOUT = 5000L;
  private static final long WRITE_TIMEOUT = 5000L;
  private static final long CONNECT_TIMEOUT = 5000L;
  private static final String BASE_URL = "https://www.v2ex.com/";

  private static Retrofit retrofit;

  public static void init(@Nonnull Context context) {
    Gson gson = new GsonBuilder().create();
    OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);


    Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
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
