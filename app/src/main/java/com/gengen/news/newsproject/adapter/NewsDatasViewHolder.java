package com.gengen.news.newsproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gengen.news.newsproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.adapter
 * Create by lxg
 * on 2017/9/26
 * at 10:40
 */
public class NewsDatasViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.one_im_layout)
    LinearLayout oneImLayout;
    @BindView(R.id.tv_one_title)
    TextView tvOneTitle;
    @BindView(R.id.im_one_01)
    ImageView imOne01;
    @BindView(R.id.tv_three_title)
    TextView tvThreeTitle;
    @BindView(R.id.im_three_01)
    ImageView imThree01;
    @BindView(R.id.im_three_02)
    ImageView imThree02;
    @BindView(R.id.im_three_03)
    ImageView imThree03;
    @BindView(R.id.three_im_layout)
    LinearLayout threeImLayout;
    @BindView(R.id.tv_show_autor)
    TextView tvShowAutor;
    @BindView(R.id.tv_show_time)
    TextView tvShowTime;

    public NewsDatasViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
