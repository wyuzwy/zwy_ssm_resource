package com.zhangwenyu.resource.bean;

public class FollowKey {
    private String followUid;

    private String followedUid;



    public String getFollowUid() {
        return followUid;
    }

    public void setFollowUid(String followUid) {
        this.followUid = followUid == null ? null : followUid.trim();
    }

    public String getFollowedUid() {
        return followedUid;
    }

    public void setFollowedUid(String followedUid) {
        this.followedUid = followedUid == null ? null : followedUid.trim();
    }

    @Override
    public String toString() {
        return "FollowKey{" +
                "followUid='" + followUid + '\'' +
                ", followedUid='" + followedUid + '\'' +
                '}';
    }
}