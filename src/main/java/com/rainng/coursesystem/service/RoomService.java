package com.rainng.coursesystem.service;

import com.rainng.coursesystem.model.entity.Room;

public interface RoomService {
    public Room findByHid(Integer rm_hotel_id,Integer room_id,String room_type,String room_img,Integer room_status,Integer rm_order_id,Integer rm_breakfast_type);
}
