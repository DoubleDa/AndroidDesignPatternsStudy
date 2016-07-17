package com.dyx.adpsp.models.chapter1;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/17 下午3:52
 * alter person：dayongxin
 * alter time：16/7/17 下午3:52
 * alter remark：
 */
public class Tenement {
    public static final float hopePrice = 100.0001f;
    public static final float hopeArea = 0.00001f;


    public static Room rentRoom(float area, float price) {
        return new Agency().getRoom(area, price);
    }
}
