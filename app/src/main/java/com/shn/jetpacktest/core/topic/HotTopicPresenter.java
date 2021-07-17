package com.shn.jetpacktest.core.topic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.shn.jetpacktest.R;
import com.shn.jetpacktest.basic.Presenter;
import com.shn.jetpacktest.basic.mmkv.MMKVManager;
import com.shn.jetpacktest.basic.network.RetrofitManager;
import com.shn.jetpacktest.core.topic.adapter.HotTopicAdapter;
import com.shn.jetpacktest.core.topic.api.TopicApi;
import com.shn.jetpacktest.core.topic.model.TopicModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HotTopicPresenter extends Presenter {
  private SwipeRefreshLayout mSwipeRefreshContainerView;
  private RecyclerView mListView;
  private HotTopicAdapter mHotTopicAdapter;

  private final TopicApi mTopicApi = RetrofitManager.create(TopicApi.class);

  @Override
  public void onBind() {
    super.onBind();
    initRecycleView();
    mSwipeRefreshContainerView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        tryToRefreshList();
      }
    });
    tryToRefreshList();
  }

  @Override
  public void onUnBind() {
    super.onUnBind();
  }

  @Override
  protected void doBindView(View mRootView) {
    super.doBindView(mRootView);
    mSwipeRefreshContainerView = mRootView.findViewById(R.id.swipe_container);
    mListView = mRootView.findViewById(R.id.list);
  }

  private void initRecycleView() {
    mListView.setLayoutManager(new LinearLayoutManager(getContext()));
    mHotTopicAdapter = new HotTopicAdapter();
    mListView.setAdapter(mHotTopicAdapter);
  }

  private void tryToRefreshList() {
    //todo:本地缓存数据，在一定时间内使用本地数据即可
    cacheHotTopic();

  }

  private void cacheHotTopic() {
    mSwipeRefreshContainerView.setRefreshing(true);
    Gson gson = new GsonBuilder().create();
    String json = MMKVManager.decode("HotTopic");
    Type listType = new TypeToken<ArrayList<TopicModel>>() {
    }.getType();
    List<TopicModel> topicModels = gson.fromJson(json, listType);
    if (topicModels == null || topicModels.isEmpty()) {
      fetchHotTopic();
    } else {
      mSwipeRefreshContainerView.setRefreshing(false);
      mHotTopicAdapter.update(topicModels);
    }
  }

  private void fetchHotTopic() {
    addToAutoDispose(mTopicApi.getHotTopics()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(
            new Consumer<List<TopicModel>>() {
              @Override
              public void accept(List<TopicModel> topicModels) throws Throwable {
                mSwipeRefreshContainerView.setRefreshing(false);
                mHotTopicAdapter.update(topicModels);
                Gson gson = new GsonBuilder().create();
                String json = gson.toJson(topicModels);
                MMKVManager.encode("HotTopic", json);
              }
            },
            new Consumer<Throwable>() {
              @Override
              public void accept(Throwable throwable) throws Throwable {
                mSwipeRefreshContainerView.setRefreshing(false);
              }
            }
        ));
  }

}
