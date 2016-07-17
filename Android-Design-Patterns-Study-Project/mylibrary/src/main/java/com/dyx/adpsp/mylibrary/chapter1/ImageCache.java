package com.dyx.adpsp.mylibrary.chapter1;

import android.graphics.Bitmap;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/16 下午11:04
 * alter person：dayongxin
 * alter time：16/7/16 下午11:04
 * alter remark：
 */
public interface ImageCache {
    public Bitmap get(String imgUrl);

    public void set(String imgUrl, Bitmap bitmap);
}
