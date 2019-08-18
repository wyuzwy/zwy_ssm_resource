package com.zhangwenyu.resource.bean;

public class PostUtils {
    private Integer postId;
    private String postTitle;

    public PostUtils() {
    }

    public PostUtils(Integer postId, String postTitle) {
        this.postId = postId;
        this.postTitle = postTitle;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
}
