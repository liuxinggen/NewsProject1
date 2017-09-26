package com.gengen.news.newsproject.net;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.net
 * Create by lxg
 * on 2017/9/25
 * at 10:52
 */
public class OkhttpUtils {

    //get请求
    public static void sendOkhttpRequest(String url, Callback callback) {

        //拿到OkHttpClient对象
        OkHttpClient client = new OkHttpClient();

        //创建Request
        Request request = new Request.Builder().get().url(url).build();

        //将Request封装为Call
        client.newCall(request).enqueue(callback);


    }


}
