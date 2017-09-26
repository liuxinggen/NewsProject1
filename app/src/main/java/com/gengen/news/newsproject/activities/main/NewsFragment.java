package com.gengen.news.newsproject.activities.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gengen.news.newsproject.R;
import com.gengen.news.newsproject.adapter.MainTableNewsAdapter;
import com.gengen.news.newsproject.base.BaseFragment;
import com.gengen.news.newsproject.bean.News;
import com.gengen.news.newsproject.utils.Constans;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment {


    @BindView(R.id.news_tablayout)
    TabLayout newsTablayout;
    @BindView(R.id.vp_news)
    ViewPager vpNews;
    Unbinder unbinder;

    private List<News> newsList;
    private MainTableNewsAdapter mTabadapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewroot = inflater.inflate(R.layout.fragment_news, container, false);
        setViewroot(viewroot);
        initCommonTopBar(getResources().getString(R.string.news), 1);
        unbinder = ButterKnife.bind(this, viewroot);
        activity = getActivity();

        initTabTitle();
        initTabLayout();


        return viewroot;
    }

    /**
     * tab的标题
     */
    private void initTabTitle() {
        newsList = new ArrayList<>();
        newsList.add(new News("推荐", Constans.TOP));
        newsList.add(new News("社会", Constans.SHEHUI));
        newsList.add(new News("国内", Constans.GUONEI));
        newsList.add(new News("国际", Constans.GUOJI));
        newsList.add(new News("娱乐", Constans.YULE));
        newsList.add(new News("体育", Constans.TIYU));
        newsList.add(new News("军事", Constans.JUNSHI));
        newsList.add(new News("科技", Constans.KEJI));
        newsList.add(new News("财经", Constans.CAIJING));
        newsList.add(new News("时尚", Constans.SHISHANG));
    }

    private void initTabLayout() {
        newsTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabadapter = new MainTableNewsAdapter(activity, newsList,
                getChildFragmentManager());
        vpNews.setAdapter(mTabadapter);
        newsTablayout.setupWithViewPager(vpNews);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
