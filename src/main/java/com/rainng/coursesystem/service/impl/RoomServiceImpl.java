package com.rainng.coursesystem.service.impl;


import com.rainng.coursesystem.dao.mapper.RoomMapper;
import com.rainng.coursesystem.model.entity.Room;
import com.rainng.coursesystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Room findByHid(Integer rm_hotel_id){
        return roomMapper.findByHid(rm_hotel_id);
    }

}
