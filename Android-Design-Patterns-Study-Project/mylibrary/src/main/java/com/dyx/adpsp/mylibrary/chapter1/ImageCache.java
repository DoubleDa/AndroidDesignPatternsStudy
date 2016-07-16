package com.dyx.adpsp.mylibrary.chapter1;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/16 下午11:04
 * alter person：dayongxin
 * alter time：16/7/16 下午11:04
 * alter remark：
 */
public class ImageCache {
    //图片缓存数据结构
    private LruCache<String, Bitmap> lruCache;

    public ImageCache() {
        initImageCache();
    }

    /**
     * 初始化图片缓存
     */
    private void initImageCache() {
        //计算可使用的最大内存
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //将1/4的内存作为图片缓存
        int imgCacheSize = maxMemory / 4;
        /**
         *
         */
        lruCache = new LruCache<String, Bitmap>(imgCacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public Bitmap get(String imgUrl) {
        return lruCache.get(imgUrl);
    }

    public void put(String imgUrl, Bitmap downBitmap) {
        lruCache.put(imgUrl, downBitmap);
    }
}
