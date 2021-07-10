package com.shn.jetpacktest.core.topic.api;

import com.google.gson.JsonObject;
import com.shn.jetpacktest.core.topic.model.TopicModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface TopicApi {
    @GET("api/topics/hot.json")
    Observable<List<TopicModel>> getHotTopics();

    @GET("api/topics/latest.json")
    Observable<JsonObject> getLatestTopics();


}
