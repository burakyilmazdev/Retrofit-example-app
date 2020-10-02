package com.example.retrofit_example_app;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private int postId;
    private int id;
    private String name;
    private String email;

    @SerializedName("body")
    private String text;

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
    public String getEmail(){
        return email;
    }
}