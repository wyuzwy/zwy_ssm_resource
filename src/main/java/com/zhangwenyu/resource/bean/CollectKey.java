package com.zhangwenyu.resource.bean;

public class CollectKey {
    private String collectUid;

    private Integer collectRid;

    public String getCollectUid() {
        return collectUid;
    }

    public void setCollectUid(String collectUid) {
        this.collectUid = collectUid == null ? null : collectUid.trim();
    }

    public Integer getCollectRid() {
        return collectRid;
    }

    public void setCollectRid(Integer collectRid) {
        this.collectRid = collectRid;
    }
}