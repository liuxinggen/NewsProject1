package com.gengen.news.newsproject.db;

import org.litepal.crud.DataSupport;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.db
 * Create by lxg
 * on 2017/9/25
 * at 10:29
 */
public class DataYule extends DataSupport {


    /**
     * uniquekey : d4ce5c0669e28723255595bccfd75588
     * title : 浙江民房凌晨大火致11死
     * date : 2017-09-25 10:21
     * category : 社会
     * author_name : 凤凰网
     * url : http://mini.eastday.com/mobile/170925102134223.html
     * thumbnail_pic_s : http://01.imgmini.eastday.com/mobile/20170925/20170925102134_ad2e6b7f5e28c59b01b8814620e30c2e_4_mwpm_03200403.jpg
     * thumbnail_pic_s02 : http://01.imgmini.eastday.com/mobile/20170925/20170925102134_ad2e6b7f5e28c59b01b8814620e30c2e_2_mwpm_03200403.jpg
     * thumbnail_pic_s03 : http://01.imgmini.eastday.com/mobile/20170925/20170925102134_ad2e6b7f5e28c59b01b8814620e30c2e_1_mwpm_03200403.jpg
     */


    private String uniquekey;
    private String title;
    private String date;
    private String category;
    private String author_name;
    private String url;
    private String thumbnail_pic_s;
    private String thumbnail_pic_s02;
    private String thumbnail_pic_s03;

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }
}
