package com.gengen.news.newsproject.bean;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.bean
 * Create by lxg
 * on 2017/9/25
 * at 17:01
 */
public class News {

    private String title;
    private String type;

    public News(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
