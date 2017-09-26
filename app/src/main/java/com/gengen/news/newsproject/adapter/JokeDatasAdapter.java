package com.gengen.news.newsproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gengen.news.newsproject.db.dbJokeData;

import java.util.List;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.adapter
 * Create by lxg
 * on 2017/9/26
 * at 16:34
 */
public class JokeDatasAdapter extends
        RecyclerView.Adapter<JokeDatasViewHolder> {

    private Context context;
    private List<dbJokeData> dataList;

    public JokeDatasAdapter(Context context, List<dbJokeData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public JokeDatasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(JokeDatasViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}
