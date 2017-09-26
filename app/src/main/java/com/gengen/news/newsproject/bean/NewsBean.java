package com.gengen.news.newsproject.bean;

import java.util.List;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.bean
 * Create by lxg
 * on 2017/9/25
 * at 10:26
 */
public class NewsBean {
    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {


        private String stat;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
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
    }
}
