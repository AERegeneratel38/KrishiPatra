package com.aelcorporation.krishipatra.forumsection;

public class ForumModel {

    private String title, desc, imageUrl, uid, commentuser, commentdetail;

    public ForumModel(String title, String desc, String imageUrl, String username, String commentdetail, String commentuser) {
        this.title = title;
        this.desc = desc;
        this.imageUrl=imageUrl;
        this.uid = uid;
        this.commentdetail = commentdetail;
        this.commentuser =  commentuser;
    }

    public ForumModel() {
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getCommentuser() {
        return commentuser;
    }

    public void setCommentuser(String commentuser) {
        this.commentuser = commentuser;
    }

    public String getCommentdetail() {
        return commentdetail;
    }

    public void setCommentdetail(String commentdetail) {
        this.commentdetail = commentdetail;
    }
}
