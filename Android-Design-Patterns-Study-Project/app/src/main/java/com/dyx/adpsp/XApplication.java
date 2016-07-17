package com.dyx.adpsp;

import android.app.Application;

import com.apkfuns.logutils.LogUtils;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/16 下午11:26
 * alter person：dayongxin
 * alter time：16/7/16 下午11:26
 * alter remark：
 */
public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.configAllowLog = true;
        LogUtils.configTagPrefix = "***ADPSP***";
    }
}
