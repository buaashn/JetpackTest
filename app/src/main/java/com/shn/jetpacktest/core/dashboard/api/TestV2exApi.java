package com.shn.jetpacktest.core.dashboard.api;

import com.google.gson.JsonObject;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestV2exApi {
  @GET("api/members/show.json")
  Observable<JsonObject> getMember(@Query("username") String username);
}
