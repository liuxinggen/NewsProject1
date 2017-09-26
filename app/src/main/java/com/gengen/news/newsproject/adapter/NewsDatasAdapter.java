package com.gengen.news.newsproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gengen.news.newsproject.R;
import com.gengen.news.newsproject.db.dbNewsData;
import com.gengen.news.newsproject.utils.GlideImageLoader;

import java.util.List;

/**
 * project name NewsProject
 * package name com.gengen.news.newsproject.adapter
 * Create by lxg
 * on 2017/9/26
 * at 10:12
 */
public class NewsDatasAdapter<T> extends RecyclerView.Adapter<NewsDatasViewHolder> {

    // 数据源
    protected List<T> datas;

    private Context context;

    // 构造方法，传入
    public NewsDatasAdapter(Context context, List<T> datas) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public NewsDatasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsDatasViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.layout_news_adapter_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsDatasViewHolder holder, int position) {
        //绑定数据
        dbNewsData dbNewsData = (dbNewsData) datas.get(position);
        if (dbNewsData.getThumbnail_pic_s02() != null &&
                dbNewsData.getThumbnail_pic_s03() != null) {
            //三张图片
            holder.oneImLayout.setVisibility(View.GONE);
            holder.threeImLayout.setVisibility(View.VISIBLE);

            GlideImageLoader.init().displayImage(context,
                    dbNewsData.getThumbnail_pic_s(), holder.imThree01);
            GlideImageLoader.init().displayImage(context,
                    dbNewsData.getThumbnail_pic_s02(), holder.imThree02);
            GlideImageLoader.init().displayImage(context,
                    dbNewsData.getThumbnail_pic_s03(), holder.imThree03);
            //
            holder.tvThreeTitle.setText(dbNewsData.getTitle());

        } else {
            //一张图片
            holder.threeImLayout.setVisibility(View.GONE);
            holder.oneImLayout.setVisibility(View.VISIBLE);
            GlideImageLoader.init().displayImage(context,
                    dbNewsData.getThumbnail_pic_s(), holder.imOne01);
//
            holder.tvOneTitle.setText(dbNewsData.getTitle());
        }
        //
        holder.tvShowAutor.setText(dbNewsData.getAuthor_name());
        holder.tvShowTime.setText(dbNewsData.getDate());

    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }
}
