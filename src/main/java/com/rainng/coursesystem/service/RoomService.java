package com.rainng.coursesystem.service;

import com.rainng.coursesystem.model.entity.Room;

public interface RoomService {
    public Room findByHid(Integer rm_hotel_id);
}
