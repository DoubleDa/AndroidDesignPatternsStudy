package com.dyx.adpsp.mylibrary.chapter1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.dyx.adpsp.mylibrary.constant.Constants;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：磁盘缓存
 * create person：dayongxin
 * create time：16/7/17 上午11:29
 * alter person：dayongxin
 * alter time：16/7/17 上午11:29
 * alter remark：
 */
public class DiskCache implements ImageCache {

    @Override
    public Bitmap get(String imgUrl) {
        //TODO 设置options属性
        return BitmapFactory.decodeFile(Constants.CACHEDIR + imgUrl);
    }

    @Override
    public void set(String imgUrl, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(Constants.CACHEDIR + imgUrl);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
