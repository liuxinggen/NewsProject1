package com.gengen.news.newsproject.applictation;

import android.app.Application;
import android.content.SharedPreferences;

import com.gengen.news.newsproject.utils.SharedPreferencesUtil;

import org.litepal.LitePal;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.applictation
 * Create by lxg
 * on 2017/9/25
 * at 10:17
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);

    }
}
