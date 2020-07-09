package com.aelcorporation.krishipatra.forumsection;

public class CommentModel {

    private String user, text;

    public CommentModel(String user, String text) {
        this.user = user;
        this.text = text;
    }

    public CommentModel() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}