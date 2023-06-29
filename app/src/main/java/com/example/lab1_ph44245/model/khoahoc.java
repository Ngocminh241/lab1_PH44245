package com.example.lab1_ph44245.model;

public class khoahoc {
    private String title;
    private String content;
    private String date;
    private int type;


    public khoahoc(String title, String content, String date, int type) {

        this.title = title;
        this.content = content;
        this.date = date;
        this.type = type;
    }

    public khoahoc() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
