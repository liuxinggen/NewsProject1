package com.gengen.news.newsproject.net;

import android.text.TextUtils;

import com.gengen.news.newsproject.bean.JokeBean;
import com.gengen.news.newsproject.bean.NewsBean;
import com.gengen.news.newsproject.db.dbJokeData;
import com.gengen.news.newsproject.db.dbNewsData;
import com.gengen.news.newsproject.utils.CommonURL;
import com.gengen.news.newsproject.utils.Constans;
import com.google.gson.Gson;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.net
 * Create by lxg
 * on 2017/9/25
 * at 11:06
 * 保存数据到数据库中
 */
public class Utility {


    /**
     * 处理新闻数据
     *
     * @param data
     * @return
     */
    public static boolean handlerNewsRequest(String data) {
        if (!TextUtils.isEmpty(data)) {
            NewsBean newsBean = new Gson().fromJson(data, NewsBean.class);
            if (newsBean.getResult() != null) {
                setNewsDataToDB(newsBean);
                return true;
            } else {
                return false;
            }

        }
        return false;
    }

    /**
     * 处理笑话数据
     *
     * @param data
     * @return
     */
    public static boolean handlerJokeRequest(String data) {
        if (!TextUtils.isEmpty(data)) {
            JokeBean jokeBean = new Gson().fromJson(data, JokeBean.class);
            if (jokeBean.getReason().equals("Success")) {
                setJokeDataToDB(jokeBean);
                return true;
            } else {
                return false;
            }

        }
        return false;
    }

    /**
     * 将新闻数据存入数据库中
     *
     * @param newsBean
     */
    private static void setNewsDataToDB(NewsBean newsBean) {
        dbNewsData dbNewsData = null;
        List<NewsBean.ResultBean.DataBean> resultList =
                newsBean.getResult().getData();
        //删除数据
        DataSupport.deleteAll(dbNewsData.class);
        for (int i = 0; i < resultList.size(); i++) {
            NewsBean.ResultBean.DataBean dataBean = resultList.get(i);
            dbNewsData = new dbNewsData(dataBean.getUniquekey(), dataBean.getTitle(),
                    dataBean.getDate(), dataBean.getCategory(), dataBean.getAuthor_name(),
                    dataBean.getUrl(), dataBean.getThumbnail_pic_s(),
                    dataBean.getThumbnail_pic_s02(), dataBean.getThumbnail_pic_s03());
            dbNewsData.save();
        }
    }

    /**
     * 将笑话数据存入数据库中
     *
     * @param jokeBean
     */
    private static void setJokeDataToDB(JokeBean jokeBean) {
        dbJokeData dbJokeData = null;
        List<JokeBean.ResultBean.DataBean> resultList =
                jokeBean.getResult().getData();
        for (int i = 0; i < resultList.size(); i++) {
            JokeBean.ResultBean.DataBean dataBean = resultList.get(i);
            dbJokeData = new dbJokeData(dataBean.getContent(), dataBean.getHashId(),
                    dataBean.getUnixtime(), dataBean.getUpdatetime(), dataBean.getUrl());
            dbJokeData.save();
        }
    }


}
