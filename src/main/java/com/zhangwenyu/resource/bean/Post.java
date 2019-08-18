package com.zhangwenyu.resource.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

public class Post {
    private Integer postId;

    private String postUid;

    private String postTitle;

    private String postText;

    private String postImage;

    @JSONField(format = "yyyy-MM-dd")
    private Date postTime;

    private List<Comment> comment;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post() {
    }


    public Post(Integer postId, String postUid, String postTitle, String postText, String postImage, Date postTime) {
        this.postId = postId;
        this.postUid = postUid;
        this.postTitle = postTitle;
        this.postText = postText;
        this.postImage = postImage;
        this.postTime = postTime;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostUid() {
        return postUid;
    }

    public void setPostUid(String postUid) {
        this.postUid = postUid == null ? null : postUid.trim();
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle == null ? null : postTitle.trim();
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText == null ? null : postText.trim();
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage == null ? null : postImage.trim();
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }


    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postUid='" + postUid + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postText='" + postText + '\'' +
                ", postImage='" + postImage + '\'' +
                ", postTime=" + postTime +
                ", comment=" + comment +
                ", user=" + user +
                '}';
    }
}