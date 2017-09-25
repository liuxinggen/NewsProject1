package com.gengen.news.newsproject.base;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gengen.news.newsproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {
    protected View viewroot;
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
     * 公共的对话框
     */
    protected android.support.v7.app.AlertDialog dialogHelper;
    /**
     * SharedPreferences
     */
    protected SharedPreferences sp;
    protected SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return viewroot;
    }

    public View getViewroot() {
        return viewroot;
    }

    public void setViewroot(View viewroot) {
        this.viewroot = viewroot;
    }

    /**
     * 初始化页面顶部工具栏
     *
     * @param title
     * @param type
     */
    protected void initCommonTopBar(String title, int type) {
        commonTopTitleTV = (TextView) viewroot.findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(title)) {
            commonTopTitleTV.setText(title);
        }
        commonTopBackLL = (LinearLayout) viewroot.findViewById(R.id.ll_back);
        commonTopBackTv = (TextView) viewroot.findViewById(R.id.tv_back);
        commonTopBackIv = (ImageView) viewroot.findViewById(R.id.iv_back);
        if (type == 1) {
            commonTopBackLL.setVisibility(View.GONE);
        } else if (type == 2) {
            commonTopBackLL.setVisibility(View.VISIBLE);
        }
        commonTopSubmitLL = (LinearLayout) viewroot.findViewById(R.id.ll_submit);
        commonTopSubmitTv = (TextView) viewroot.findViewById(R.id.tv_submit);
        commonTopSubmitIv = (ImageView) viewroot.findViewById(R.id.iv_submit);

    }

}
