package com.shn.jetpacktest.core.topic.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TopicModel implements Serializable {
    @SerializedName("node")
    public NodeModel mNode;

    @SerializedName("member")
    public UserModel mUser;

    @SerializedName("id")
    public long id;

    @SerializedName("title")
    public String mTile;

    @SerializedName("url")
    public String mUrl;

    @SerializedName("replies")
    public int mRepliesNumber;

    @SerializedName("last_modified")
    public long mLastModifiedMs;

    @SerializedName("last_reply_by")
    public String mLastReplyUserName;

    @SerializedName("last_touched")
    public long mLastTouchedMs;

    @SerializedName("created")
    public long mCreatedMs;

    @SerializedName("content")
    public String mContent;

    @SerializedName("content_rendered")
    public String mContentHtml;

}
