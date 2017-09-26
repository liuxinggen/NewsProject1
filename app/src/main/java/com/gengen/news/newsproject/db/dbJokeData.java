package com.gengen.news.newsproject.db;

import org.litepal.crud.DataSupport;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.db
 * Create by lxg
 * on 2017/9/26
 * at 16:10
 */
public class dbJokeData extends DataSupport {

    private String content;
    private String hashId;
    private int unixtime;
    private String updatetime;
    private String url;

    public dbJokeData(String content, String hashId, int unixtime,
                      String updatetime, String url) {
        this.content = content;
        this.hashId = hashId;
        this.unixtime = unixtime;
        this.updatetime = updatetime;
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(int unixtime) {
        this.unixtime = unixtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
