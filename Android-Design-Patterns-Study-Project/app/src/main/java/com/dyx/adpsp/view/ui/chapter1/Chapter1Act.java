package com.dyx.adpsp.view.ui.chapter1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.dyx.adpsp.R;
import com.dyx.adpsp.constants.Constants;
import com.dyx.adpsp.mylibrary.chapter1.ImageLoader;
import com.dyx.adpsp.mylibrary.chapter1.MemoryCache;
import com.dyx.adpsp.mylibrary.chapter1.MemoryDiskCache;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/16 下午10:56
 * alter person：dayongxin
 * alter time：16/7/16 下午10:56
 * alter remark：
 */
public class Chapter1Act extends Activity {
    @Bind(R.id.iv_test)
    ImageView ivTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //获取ImageLoader对象
        ImageLoader mImageLoader = new ImageLoader();
        /**
         * 设置缓存
         */
        //内存缓存
        //mImageLoader.setImageCache(new MemoryCache());
        //SD缓存
        //mImageLoader.setImageCache(new DiskCache());
        //二级缓存
        mImageLoader.setImageCache(new MemoryDiskCache());
        mImageLoader.displayImage(Constants.URL_TEST_IMG, ivTest);
    }
}
