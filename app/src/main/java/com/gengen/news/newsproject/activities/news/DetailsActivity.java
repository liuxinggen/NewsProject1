package com.gengen.news.newsproject.activities.news;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gengen.news.newsproject.R;
import com.gengen.news.newsproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActivity {
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
    @BindView(R.id.webview)
    WebView webview;
    private String title, url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        initView();
        initWebView();
    }

    private void initWebView() {
        WebSettings setting=webview.getSettings();
        //开启javascript支持
        setting.setJavaScriptEnabled(true);
        webview.loadUrl(url);
    }

    private void initView() {
        title = getIntent().getStringExtra("title");
        url = getIntent().getStringExtra("url");

        initCommonTopBar(title, 2);
        commonTopBackLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
