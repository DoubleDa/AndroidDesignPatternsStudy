package com.dyx.adpsp.mylibrary.chapter1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：图片加载器
 * create person：dayongxin
 * create time：16/7/16 下午11:03
 * alter person：dayongxin
 * alter time：16/7/16 下午11:03
 * alter remark：
 */
public class ImageLoader {
    /**
     * 创建ImageCache对象
     */
    ImageCache mImageCache = new MemoryCache();
    /**
     * TODO 创建线程池
     */
    ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * 注入缓存实现
     *
     * @param imageCache
     */
    public void setImageCache(ImageCache imageCache) {
        mImageCache = imageCache;
    }

    /**
     * 显示图片
     *
     * @param imgUrl
     * @param imageView
     */
    public void displayImage(final String imgUrl, final ImageView imageView) {
        //获取缓存中的图片
        Bitmap bitmap = mImageCache.get(imgUrl);
        /**
         * 显示图片
         */
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        //为ImageView设置Tag
        imageView.setTag(imgUrl);
        /**
         * 使用线程池下载图片
         */
        service.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap downBitmap = downloadImage(imgUrl);
                if (downBitmap == null) {
                    return;
                }
                /**
                 * 设置图片
                 */
                if (imageView.getTag().equals(imgUrl)) {
                    imageView.setImageBitmap(downBitmap);
                }
                //将已下载图片放入缓存
                mImageCache.set(imgUrl, downBitmap);
            }
        });
    }

    private Bitmap downloadImage(String imgUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imgUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
