package com.gengen.news.newsproject.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.util.Util;

/**
 * project name Online_Food_Client
 * package name com.gengen.food.commons
 * Create by lxg
 * on 2017/4/24
 * at 14:55
 */
public class GlideImageLoader {

    private static GlideImageLoader glideImageLoader = new GlideImageLoader();

    public static GlideImageLoader init() {
        return glideImageLoader;
    }

    public void displayImage(Context context, Object path, ImageView imageView) {
        if (Util.isOnMainThread()) {
            //Glide 加载图片用法
            Glide.with(context).load(path).into(imageView);
        }
    }

    public void displayGifImage(Context context, Object path, ImageView imageView) {
        if (Util.isOnMainThread()) {
            if ("gif".indexOf((String) path) > -1) {
                //Glide 加载gif图片用法
                Glide.with(context)
                        .asGif()
                        .load(path)
                        .into(imageView);
            } else {
                //Glide 加载图片用法
                Glide.with(context).load(path).into(imageView);
            }
        }
    }
}
