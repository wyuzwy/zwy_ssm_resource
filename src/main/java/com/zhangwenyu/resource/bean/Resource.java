package com.zhangwenyu.resource.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Resource {
    private Integer resourceId;

    private Integer resourceCid;

    private String resourceUid;

    private String resourceName;

    private String resourceImage;

    private String resourceUrl;

    private String resourceDesc;

    private String resourceLevel;

    @JSONField(format = "yyyy-MM-dd")
    private Date resourceTime;

    private Integer resourceGood;

    private User user;

    private CategoryKey categoryKey;

    public CategoryKey getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(CategoryKey categoryKey) {
        this.categoryKey = categoryKey;
    }

    public Resource() {
    }

    public Resource(Integer resourceId, Integer resourceCid, String resourceUid, String resourceName, String resourceImage, String resourceUrl, String resourceDesc, String resourceLevel, Date resourceTime, Integer resourceGood) {
        this.resourceId = resourceId;
        this.resourceCid = resourceCid;
        this.resourceUid = resourceUid;
        this.resourceName = resourceName;
        this.resourceImage = resourceImage;
        this.resourceUrl = resourceUrl;
        this.resourceDesc = resourceDesc;
        this.resourceLevel = resourceLevel;
        this.resourceTime = resourceTime;
        this.resourceGood = resourceGood;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getResourceCid() {
        return resourceCid;
    }

    public void setResourceCid(Integer resourceCid) {
        this.resourceCid = resourceCid;
    }

    public String getResourceUid() {
        return resourceUid;
    }

    public void setResourceUid(String resourceUid) {
        this.resourceUid = resourceUid == null ? null : resourceUid.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage == null ? null : resourceImage.trim();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc == null ? null : resourceDesc.trim();
    }

    public String getResourceLevel() {
        return resourceLevel;
    }

    public void setResourceLevel(String resourceLevel) {
        this.resourceLevel = resourceLevel == null ? null : resourceLevel.trim();
    }

    public Date getResourceTime() {
        return resourceTime;
    }

    public void setResourceTime(Date resourceTime) {
        this.resourceTime = resourceTime;
    }

    public Integer getResourceGood() {
        return resourceGood;
    }

    public void setResourceGood(Integer resourceGood) {
        this.resourceGood = resourceGood;
    }


    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", resourceCid=" + resourceCid +
                ", resourceUid='" + resourceUid + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", resourceImage='" + resourceImage + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", resourceDesc='" + resourceDesc + '\'' +
                ", resourceLevel='" + resourceLevel + '\'' +
                ", resourceTime=" + resourceTime +
                ", resourceGood=" + resourceGood +
                ", user=" + user +
                ", categoryKey=" + categoryKey +
                '}';
    }
}