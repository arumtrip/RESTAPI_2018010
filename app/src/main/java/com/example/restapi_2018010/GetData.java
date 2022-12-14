package com.example.restapi_2018010;

import com.google.gson.annotations.SerializedName;

public class GetData {
    private int id;
    private int userId;
    private String title;

    @SerializedName("body")
    private String text;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}