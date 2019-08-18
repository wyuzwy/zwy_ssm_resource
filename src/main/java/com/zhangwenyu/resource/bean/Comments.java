package com.zhangwenyu.resource.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Comments {
    private Integer commentId;

    private Integer commentPid;

    private String commentUid;

    private String commentText;

    @JSONField(format = "yyyy-MM-dd")
    private Date commentTime;

    private PostUtils post;

    public Comments() {
    }

    public Comments(Integer commentId, Integer commentPid, String commentUid, String commentText, Date commentTime) {
        this.commentId = commentId;
        this.commentPid = commentPid;
        this.commentUid = commentUid;
        this.commentText = commentText;
        this.commentTime = commentTime;
    }

    public PostUtils getPost() {
        return post;
    }

    public void setPost(PostUtils post) {
        this.post = post;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    public String getCommentUid() {
        return commentUid;
    }

    public void setCommentUid(String commentUid) {
        this.commentUid = commentUid;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentId=" + commentId +
                ", commentPid=" + commentPid +
                ", commentUid='" + commentUid + '\'' +
                ", commentText='" + commentText + '\'' +
                ", commentTime=" + commentTime +
                '}';
    }
}
