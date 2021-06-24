package com.rainng.coursesystem.dao.mapper;

import com.rainng.coursesystem.model.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoomMapper {
    public Room findByHid(Integer rm_hotel_id, Integer room_id, String room_type, String room_img, Integer room_status, Integer rm_breakfast_type, Integer rmBreakfastType);
}
