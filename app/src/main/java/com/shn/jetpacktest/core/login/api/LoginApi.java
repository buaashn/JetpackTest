package com.shn.jetpacktest.core.login.api;

import android.graphics.Bitmap;

import com.shn.jetpacktest.basic.network.RetrofitManager;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApi {
  LoginApi logApi = RetrofitManager.create(LoginApi.class);

  static LoginApi get() {
    return logApi;
  }

  @GET("signin")
  Observable<String> getLoginPage();

  @POST("signin")
  @Headers({"Referer:https://www.v2ex.com/signin", "Origin:https://www.v2ex.com"})
  @FormUrlEncoded
  Observable<String> postLogin(@FieldMap Map<String, String> form);

  @GET("_captcha")
  Observable<Bitmap> getCaptcha(@Query("once") String once);
}

