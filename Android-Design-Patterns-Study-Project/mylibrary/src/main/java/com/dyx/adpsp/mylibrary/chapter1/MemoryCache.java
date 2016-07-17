package com.dyx.adpsp.mylibrary.chapter1;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：内存缓存
 * create person：dayongxin
 * create time：16/7/16 下午11:04
 * alter person：dayongxin
 * alter time：16/7/16 下午11:04
 * alter remark：
 */
public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> lruCache;

    public MemoryCache() {
        initLruCache();
    }

    private void initLruCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int useableMemory = maxMemory / 4;
        lruCache = new LruCache<String, Bitmap>(useableMemory) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(String imgUrl) {
        return lruCache.get(imgUrl);
    }

    @Override
    public void set(String imgUrl, Bitmap bitmap) {
        lruCache.put(imgUrl, bitmap);
    }
}
