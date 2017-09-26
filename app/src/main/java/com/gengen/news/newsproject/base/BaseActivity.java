package com.gengen.news.newsproject.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gengen.news.newsproject.R;
import com.gengen.news.newsproject.utils.Constans;

public class BaseActivity extends AppCompatActivity {
    /**
     * 公用的当前Activity的对象
     */
    protected Activity activity;
    /**
     * 公用的Intent对象
     */
    protected Intent intent;
    /**
     * 公用的Bundle对象
     */
    protected Bundle bundle;
    /**
     * 公用的等待对话框对象
     */
    protected Dialog progressDialog;
    /**
     * 顶部返回布局
     */
    protected LinearLayout commonTopBackLL;
    protected TextView commonTopBackTv;
    protected ImageView commonTopBackIv;
    /**
     * 顶部标题TextView
     */
    protected TextView commonTopTitleTV;
    /**
     * 顶部操作布局
     */
    protected LinearLayout commonTopSubmitLL;
    protected TextView commonTopSubmitTv;
    protected ImageView commonTopSubmitIv;
    /**
     * 暂无数据的界面显示
     */
    protected LinearLayout llNodata;
    protected TextView tvNodata;
    /**
     * 公共的对话框
     */
    protected android.support.v7.app.AlertDialog dialogHelper;
    /**
     * SharedPreferences
     */
    protected SharedPreferences sp;
    protected SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Constans.activity = this;


    }

    /**
     * 初始化页面顶部工具栏
     *
     * @param title
     * @param type
     */
    protected void initCommonTopBar(String title, int type) {
        commonTopTitleTV = (TextView) this.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title)) {
            commonTopTitleTV.setText(title);
        }
        commonTopBackLL = (LinearLayout) this.findViewById(R.id.ll_back);
        commonTopBackTv = (TextView) this.findViewById(R.id.tv_back);
        commonTopBackIv = (ImageView) this.findViewById(R.id.iv_back);
        if (type == 1) {
            commonTopBackLL.setVisibility(View.GONE);
        } else if (type == 2) {
            commonTopBackLL.setVisibility(View.VISIBLE);
        }
        commonTopSubmitLL = (LinearLayout) this.findViewById(R.id.ll_submit);
        commonTopSubmitTv = (TextView) this.findViewById(R.id.tv_submit);
        commonTopSubmitIv = (ImageView) this.findViewById(R.id.iv_submit);

    }

    /**
     * 显示暂无数据
     *
     * @param msg
     * @param isShow
     */
    protected void getFailure(String msg, boolean isShow) {
        if (isShow) {
            Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
        }
        llNodata = (LinearLayout) this.findViewById(R.id.ll_nodata);
        tvNodata = (TextView) this.findViewById(R.id.tv_nodata);
        llNodata.setVisibility(View.VISIBLE);
        tvNodata.setText(msg);
    }


}
