package com.gengen.news.newsproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gengen.news.newsproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.adapter
 * Create by lxg
 * on 2017/9/26
 * at 16:35
 */
public class JokeDatasViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_joke_content)
    TextView tvJokeContent;
    @BindView(R.id.iv_joke_img)
    ImageView ivJokeImg;
    public JokeDatasViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
