package com.gengen.news.newsproject.activities.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gengen.news.newsproject.R;
import com.gengen.news.newsproject.adapter.JokeDatasAdapter;
import com.gengen.news.newsproject.base.BaseFragment;
import com.gengen.news.newsproject.db.dbJokeData;
import com.gengen.news.newsproject.net.OkhttpUtils;
import com.gengen.news.newsproject.net.Utility;
import com.gengen.news.newsproject.utils.CommonURL;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeFragment extends BaseFragment {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.ll_back)
    LinearLayout llBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_submit)
    ImageView ivSubmit;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.ll_submit)
    LinearLayout llSubmit;
    @BindView(R.id.common_recycerview)
    RecyclerView commonRecycerview;
    @BindView(R.id.common_recyclerview_ll)
    LinearLayout commonRecyclerviewLl;
    @BindView(R.id.iv_nodata)
    ImageView ivNodata;
    @BindView(R.id.tv_nodata)
    TextView tvNodata;
    @BindView(R.id.ll_nodata)
    LinearLayout llNodata;
    @BindView(R.id.swipwlayout)
    SwipeRefreshLayout swipwlayout;
    Unbinder unbinder;

    private List<dbJokeData> jokeList = null;

    private JokeDatasAdapter jokeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewroot = inflater.inflate(R.layout.fragment_joke, container, false);
        setViewroot(viewroot);
        initCommonTopBar(getResources().getString(R.string.joke), 1);
        activity = getActivity();
        unbinder = ButterKnife.bind(this, viewroot);
        initView();
        queryData();
        return viewroot;
    }

    private void initView() {
        jokeAdapter = new JokeDatasAdapter(activity, jokeList);
        commonRecycerview.setLayoutManager(new LinearLayoutManager(activity));
        commonRecycerview.setAdapter(jokeAdapter);
    }

    /**
     * 获取数据，优先从数据库中获取，如果没有就从服务端获取
     */
    private void queryData() {
        jokeList = DataSupport.findAll(dbJokeData.class);
        if (jokeList.size() > 0) {
            jokeAdapter.notifyDataSetChanged();
        } else {
            queryDatafromService();
        }


    }

    /**
     * 从服务端获取数据
     */
    private void queryDatafromService() {
        String url = CommonURL.JOKESURL + "?&pagesize=10"
                + "&key=" + CommonURL.KEY_JOKE;
        OkhttpUtils.sendOkhttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getFailure("网络错误", false);
            }

            @Override
            public void onResponse(Call call, Response response)
                    throws IOException {
                String responseStr = response.body().string();
                boolean result = false;
                result = Utility.handlerJokeRequest(responseStr);

                if (result) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            jokeAdapter.notifyDataSetChanged();
                        }
                    });
                } else {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            getFailure("数据请求失败，请稍后重试", true);
                        }
                    });
                }


            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
