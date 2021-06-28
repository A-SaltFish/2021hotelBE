package com.rainng.coursesystem.service;

import com.rainng.coursesystem.model.entity.Room;

import java.util.List;

public interface RoomService {
    public List<Room> findByHid(Integer rm_hotel_id);
//    public Room findByHid(Integer rm_hotel_id,Integer room_id,String room_type,String room_img,Integer room_status,Integer rm_order_id,Integer rm_breakfast_type);
}
