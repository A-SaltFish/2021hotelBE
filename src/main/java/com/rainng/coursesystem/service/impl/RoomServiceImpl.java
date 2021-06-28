package com.rainng.coursesystem.service.impl;


import com.rainng.coursesystem.dao.mapper.RoomMapper;
import com.rainng.coursesystem.model.entity.Room;
import com.rainng.coursesystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

//    @Override
//    public Room findByHid(Integer rm_hotel_id,Integer room_id,String room_type,String room_img,Integer room_status,Integer rm_order_id,Integer rm_breakfast_type){
//        return roomMapper.findByHid(rm_hotel_id,room_id,room_type,room_img,room_status,rm_order_id,rm_breakfast_type);
//    }
    @Override
    public List<Room> findByHid(Integer rm_hotel_id){
        return roomMapper.findByHid(rm_hotel_id);
    }

}
