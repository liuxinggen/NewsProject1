package com.gengen.news.newsproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gengen.news.newsproject.R;
import com.gengen.news.newsproject.db.dbJokeData;
import com.gengen.news.newsproject.utils.GlideImageLoader;

import java.util.List;

import butterknife.BindView;

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
        return new JokeDatasViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.jike_datas_show_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(JokeDatasViewHolder holder, int position) {

        dbJokeData jokeData = dataList.get(position);

        //
        holder.tvJokeContent.setText(jokeData.getContent());

        GlideImageLoader.init()
                .displayGifImage(context, jokeData.getUrl(), holder.ivJokeImg);
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}
