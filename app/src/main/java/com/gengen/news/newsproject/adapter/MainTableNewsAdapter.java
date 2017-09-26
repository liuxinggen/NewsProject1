package com.gengen.news.newsproject.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gengen.news.newsproject.activities.news.NewsTypeFragment;
import com.gengen.news.newsproject.bean.News;
import com.gengen.news.newsproject.utils.LogUtils;

import java.util.List;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.adapter
 * Create by lxg
 * on 2017/9/25
 * at 16:35
 */
public class MainTableNewsAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<News> news;

    public MainTableNewsAdapter(Context context,
                                List<News> news, FragmentManager fm) {
        super(fm);
        this.context = context;
        this.news = news;

    }

    @Override
    public Fragment getItem(int position) {
        LogUtils.i("position", "" + position);
        return new NewsTypeFragment()
                .newInstance(news, position);
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return news.get(position).getTitle();
    }
}
