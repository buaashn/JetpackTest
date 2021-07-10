package com.shn.jetpacktest.core.topic.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable {
    @SerializedName("id")
    public long mUserId;

    @SerializedName("username")
    public String mUserName;

    @SerializedName("avatar_normal")
    public String mAvatarNormal;

    @SerializedName("avatar_mini")
    public String mAvatarMini;

    @SerializedName("avatar_large")
    public String mAvatarLarge;

    @SerializedName("created")
    public long mCreatedMs;

    @SerializedName("website")
    public String mWebsiteLink;

    @SerializedName("github")
    public String mGithubLink;

    @SerializedName("twitter")
    public String mTwitterLink;


}
