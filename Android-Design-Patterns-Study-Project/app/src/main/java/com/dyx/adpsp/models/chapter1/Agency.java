package com.dyx.adpsp.models.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * project name：Android-Design-Patterns-Study-Project
 * class describe：中介
 * create person：dayongxin
 * create time：16/7/17 下午3:46
 * alter person：dayongxin
 * alter time：16/7/17 下午3:46
 * alter remark：
 */
public class Agency {
    List<Room> rooms = new ArrayList<>();

    public Agency() {
        for (int i = 0; i < 5; i++) {
            rooms.add(new Room(14 + i, (14 + i) * 150));
        }
    }

    public Room getRoom(float area, float price) {
        for (Room room : rooms) {
            if (isAgreeWithMe(area, price, room)) {
                return room;
            }
        }
        return null;
    }

    private boolean isAgreeWithMe(float area, float price, Room room) {
        return Math.abs(room.roomPrice - price) < Tenement.hopePrice && Math.abs(room.roomArea - area) < Tenement.hopeArea;
    }
}
