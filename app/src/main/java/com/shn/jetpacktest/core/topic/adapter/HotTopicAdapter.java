package com.shn.jetpacktest.core.topic.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.shn.jetpacktest.R;
import com.shn.jetpacktest.core.topic.model.TopicModel;

import java.util.ArrayList;
import java.util.List;

public class HotTopicAdapter extends RecyclerView.Adapter<HotTopicAdapter.HotTopicViewHolder> {
  private final List<TopicModel> mHotTopics;

  public HotTopicAdapter() {
    mHotTopics = new ArrayList<>();
  }

  public HotTopicAdapter(List<TopicModel> hotTopics) {
    mHotTopics = new ArrayList<>();
    mHotTopics.addAll(hotTopics);
  }

  public void update(List<TopicModel> hotTopics) {
    mHotTopics.clear();
    mHotTopics.addAll(hotTopics);
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public HotTopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new HotTopicViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.container_hot_topic, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull HotTopicViewHolder holder, int position) {
    holder.bind(mHotTopics.get(position));
  }

  @Override
  public int getItemCount() {
    return mHotTopics.size();
  }

  public static class HotTopicViewHolder extends RecyclerView.ViewHolder {
    private final SimpleDraweeView mUserAvatar;
    private final TextView mUserName;
    private final TextView mTitle;

    public HotTopicViewHolder(@NonNull View itemView) {
      super(itemView);
      mUserAvatar = itemView.findViewById(R.id.user_avatar);
      mUserName = itemView.findViewById(R.id.user_name);
      mTitle = itemView.findViewById(R.id.title);
    }

    public void bind(TopicModel topicModel) {
      if (topicModel.mUser != null) {
        Uri uri = Uri.parse(topicModel.mUser.mAvatarNormal);
        mUserAvatar.setImageURI(uri);
        mUserName.setText(topicModel.mUser.mUserName);
      }
      mTitle.setText(topicModel.mTile);
    }
  }
}
