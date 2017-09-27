package com.gengen.news.newsproject.activities.news;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gengen.news.newsproject.R;
import com.gengen.news.newsproject.adapter.NewsDatasAdapter;
import com.gengen.news.newsproject.base.BaseFragment;
import com.gengen.news.newsproject.bean.News;
import com.gengen.news.newsproject.db.dbNewsData;
import com.gengen.news.newsproject.net.OkhttpUtils;
import com.gengen.news.newsproject.net.Utility;
import com.gengen.news.newsproject.utils.CommonURL;
import com.gengen.news.newsproject.utils.Constans;
import com.gengen.news.newsproject.utils.LogUtils;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 按类型展示新闻内容
 */
public class NewsTypeFragment extends BaseFragment {

    @BindView(R.id.common_recycerview)
    RecyclerView commonRecycerview;
    @BindView(R.id.iv_nodata)
    ImageView ivNodata;
    @BindView(R.id.tv_nodata)
    TextView tvNodata;
    @BindView(R.id.ll_nodata)
    LinearLayout llNodata;
    @BindView(R.id.common_recyclerview_ll)
    LinearLayout commonRecyclerviewLl;
    @BindView(R.id.swipwlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    Unbinder unbinder;
    /**
     * 获取类型type
     */
    private String type;
    private int index;
    private List<News> news;

    //数据适配器
    private NewsDatasAdapter datasAdapter;


    //数据列表
    private List<dbNewsData> listDatadb = null;


    public static NewsTypeFragment newInstance(List<News> news, int positon) {
        NewsTypeFragment newsTypeFragment = new NewsTypeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("news", (Serializable) news);
        bundle.putInt("positon", positon);
        newsTypeFragment.setArguments(bundle);
        return newsTypeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewroot = inflater.inflate(R.layout.fragment_news_type, container, false);
        unbinder = ButterKnife.bind(this, viewroot);
        activity = getActivity();
        news = (List<News>) getArguments().getSerializable("news");
        index = getArguments().getInt("positon", 0);
        initView();
        initEvent();
        return viewroot;
    }

    private void initEvent() {
        /**
         * 刷新
         */
        mSwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        mSwipeRefreshLayout.setRefreshing(false);
                        commonRecyclerviewLl.setVisibility(View.VISIBLE);
                        llNodata.setVisibility(View.GONE);
                        queryDatafromServer(type);
                    }
                });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        type = news.get(index).getType();
        if (!TextUtils.isEmpty(type)) {
            queryData(type);
        } else {
            getFailure("参数传递错误", true);
        }
    }

    private void initView() {
        commonRecycerview.setLayoutManager(new LinearLayoutManager(activity));

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.red),
                getResources().getColor(R.color.blue), getResources().getColor(R.color.green));
    }

    /**
     * 从服务器中获取数据
     *
     * @param type
     */
    private void queryDatafromServer(final String type) {
        String url = CommonURL.NEWSURL + "?type=" + type + "&key=" + CommonURL.KEY_NEWS;
        LogUtils.i("NEWS_URL", url);
        OkhttpUtils.sendOkhttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        commonRecyclerviewLl.setVisibility(View.GONE);
                        getFailure("网络错误", true);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                boolean result = false;
                String respinseStr = response.body().string();
                result = Utility.handlerNewsRequest(respinseStr);
                if (result) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            queryData(type);
                        }
                    });
                } else {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            commonRecyclerviewLl.setVisibility(View.GONE);
                            getFailure("数据获取失败，请稍后重试", false);
                        }
                    });

                }
            }
        });
    }

    /**
     * 查询数据，优先从数据库中查询，如果没有就从服务端获取
     */
    private void queryData(String type) {
        /**
         * 根据不同的type来查询数据
         */
        String title = null;
//        if (!("时尚".equals(news.get(index).getTitle()))) {
            title = news.get(index).getTitle();
//        }
        listDatadb = DataSupport.where("category=?",
                String.valueOf(title)).find(dbNewsData.class);
        if (listDatadb.size() > 0) {
            datasAdapter = new NewsDatasAdapter(activity, listDatadb);
            commonRecycerview.setAdapter(datasAdapter);
        } else {
            queryDatafromServer(type);
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
