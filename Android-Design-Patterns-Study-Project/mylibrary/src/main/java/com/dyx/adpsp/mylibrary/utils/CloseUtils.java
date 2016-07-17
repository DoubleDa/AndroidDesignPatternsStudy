package com.dyx.adpsp.mylibrary.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/17 下午3:16
 * alter person：dayongxin
 * alter time：16/7/17 下午3:16
 * alter remark：
 */
public class CloseUtils {
    /**
     * 关闭Closeable对象
     *
     * @param closeable
     */
    public static void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
