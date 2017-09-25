package com.gengen.news.newsproject.activities;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gengen.news.newsproject.R;
import com.gengen.news.newsproject.activities.main.HisFragment;
import com.gengen.news.newsproject.activities.main.JokeFragment;
import com.gengen.news.newsproject.activities.main.NewsFragment;
import com.gengen.news.newsproject.activities.main.WeatherFragment;
import com.gengen.news.newsproject.base.BaseActivity;
import com.gengen.news.newsproject.views.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.vp_content)
    NoScrollViewPager vpContent;
    @BindView(R.id.im_news)
    ImageView imNews;
    @BindView(R.id.tv_news)
    TextView tvNews;
    @BindView(R.id.ll_news)
    LinearLayout llNews;
    @BindView(R.id.im_weather)
    ImageView imWeather;
    @BindView(R.id.tv_weather)
    TextView tvWeather;
    @BindView(R.id.ll_weather)
    LinearLayout llWeather;
    @BindView(R.id.im_his)
    ImageView imHis;
    @BindView(R.id.tv_his)
    TextView tvHis;
    @BindView(R.id.ll_his)
    LinearLayout llHis;
    @BindView(R.id.im_joke)
    ImageView imJoke;
    @BindView(R.id.tv_joke)
    TextView tvJoke;
    @BindView(R.id.ll_joke)
    LinearLayout llJoke;

    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activity = this;
        initFragment();
        initEvent();

    }

    private void initEvent() {
        vpContent.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                selectedTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vpContent.setOffscreenPageLimit(1);//设置viewpager的预加载个数
        selectedTab(0);
    }

    /**
     * 设置选中的Tab的状态
     *
     * @param position
     */
    private void selectedTab(int position) {
        setTabStatue();
        switch (position) {
            case 0:
                imNews.setImageResource(R.mipmap.ic_launcher);
                tvNews.setTextColor(getResources().getColor(R.color.royalblue));
                vpContent.setCurrentItem(0);
                break;
            case 1:
                imWeather.setImageResource(R.mipmap.ic_launcher);
                tvWeather.setTextColor(getResources().getColor(R.color.royalblue));
                vpContent.setCurrentItem(1);
                break;
            case 2:
                imHis.setImageResource(R.mipmap.ic_launcher);
                tvHis.setTextColor(getResources().getColor(R.color.royalblue));
                vpContent.setCurrentItem(2);

                break;
            case 3:
                imJoke.setImageResource(R.mipmap.ic_launcher);
                tvJoke.setTextColor(getResources().getColor(R.color.royalblue));
                vpContent.setCurrentItem(3);

                break;


        }


    }

    /**
     * 重置底部tab的状态
     */
    private void setTabStatue() {
        imNews.setImageResource(R.mipmap.ic_launcher);
        tvNews.setTextColor(getResources().getColor(R.color.grey));

        imWeather.setImageResource(R.mipmap.ic_launcher);
        tvWeather.setTextColor(getResources().getColor(R.color.grey));

        imHis.setImageResource(R.mipmap.ic_launcher);
        tvHis.setTextColor(getResources().getColor(R.color.grey));

        imJoke.setImageResource(R.mipmap.ic_launcher);
        tvJoke.setTextColor(getResources().getColor(R.color.grey));

    }


    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new WeatherFragment());
        fragments.add(new HisFragment());
        fragments.add(new JokeFragment());


    }


    @OnClick({R.id.ll_news, R.id.ll_weather, R.id.ll_his, R.id.ll_joke})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_news:
                selectedTab(0);
                break;
            case R.id.ll_weather:
                selectedTab(1);
                break;
            case R.id.ll_his:
                selectedTab(2);
                break;
            case R.id.ll_joke:
                selectedTab(3);
                break;
        }
    }


    long time = 0;

    @Override
    public void onBackPressed() {

        long currentTime = System.currentTimeMillis();
        if ((currentTime - time) > 2000) {
            Toast.makeText(activity, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            time = currentTime;
        } else {
            finish();
        }
    }
}
