package com.shn.jetpacktest.core.topic;

import com.shn.jetpacktest.widget.BaseRefreshFragment;

public class TopicFragment extends BaseRefreshFragment {
  public TopicFragment() {
    addPresenter(new HotTopicPresenter());
  }
}
