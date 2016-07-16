package com.dyx.adpsp.view.ui.chapter1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.dyx.adpsp.R;
import com.dyx.adpsp.constants.Constants;
import com.dyx.adpsp.mylibrary.chapter1.ImageLoader;

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
        ImageLoader mImageLoader = new ImageLoader();
        mImageLoader.displayImage(Constants.URL_TEST_IMG, ivTest);
    }
}
