package com.rainng.coursesystem.dao.mapper;

import com.rainng.coursesystem.model.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoomMapper {
    public List<Room> findByHid(Integer rm_hotel_id);
}
