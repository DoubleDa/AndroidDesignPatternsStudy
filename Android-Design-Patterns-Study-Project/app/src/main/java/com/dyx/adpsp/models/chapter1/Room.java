package com.dyx.adpsp.models.chapter1;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：房屋
 * create person：dayongxin
 * create time：16/7/17 下午3:43
 * alter person：dayongxin
 * alter time：16/7/17 下午3:43
 * alter remark：
 */
public class Room {
    public float roomArea;
    public float roomPrice;

    public Room(float roomArea, float roomPrice) {
        this.roomArea = roomArea;
        this.roomPrice = roomPrice;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomArea=" + roomArea +
                ", roomPrice=" + roomPrice +
                '}';
    }

    public float getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(float roomArea) {
        this.roomArea = roomArea;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }
}
