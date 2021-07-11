package com.shn.jetpacktest.core.topic;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.shn.jetpacktest.R;
import com.shn.jetpacktest.basic.BasePresenter;
import com.shn.jetpacktest.basic.network.RetrofitManager;
import com.shn.jetpacktest.core.topic.adapter.HotTopicAdapter;
import com.shn.jetpacktest.core.topic.api.TopicApi;
import com.shn.jetpacktest.core.topic.model.TopicModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HotTopicPresenter extends BasePresenter {
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
    fetchHotTopic();

  }

  private void fetchHotTopic() {
    mSwipeRefreshContainerView.setRefreshing(true);
    addToAutoDispose(mTopicApi.getHotTopics()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(
            new Consumer<List<TopicModel>>() {
              @Override
              public void accept(List<TopicModel> topicModels) throws Throwable {
                mSwipeRefreshContainerView.setRefreshing(false);
                mHotTopicAdapter.update(topicModels);
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
