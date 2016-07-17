package com.dyx.adpsp.mylibrary.chapter1;

import android.graphics.Bitmap;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：二级缓存
 * create person：dayongxin
 * create time：16/7/17 上午11:38
 * alter person：dayongxin
 * alter time：16/7/17 上午11:38
 * alter remark：
 */
public class MemoryDiskCache implements ImageCache {
    ImageCache mMemoryCache = new MemoryCache();
    ImageCache mDiskCache = new DiskCache();

    @Override
    public Bitmap get(String imgUrl) {
        Bitmap bitmap = mMemoryCache.get(imgUrl);
        if (bitmap == null) {
            bitmap = mDiskCache.get(imgUrl);
        }
        return bitmap;
    }

    @Override
    public void set(String imgUrl, Bitmap bitmap) {
        mMemoryCache.set(imgUrl, bitmap);
        mDiskCache.set(imgUrl, bitmap);
    }
}
