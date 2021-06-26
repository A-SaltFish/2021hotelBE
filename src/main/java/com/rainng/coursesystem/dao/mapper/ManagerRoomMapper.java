package com.rainng.coursesystem.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.HotelRoomEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelRoomVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRoomMapper extends BaseMapper<HotelRoomEntity> {

    List<HotelRoomVO> listHotelRoom(@Param("managerId")Integer managerId);

    int deleteRoomById(@Param("hotelId")Integer hotelId,@Param("roomId")Integer roomId);

    int decreaseRoomByHotelId(@Param("hotelId")Integer hotelId);

    int increaseRoomByHotelId(@Param("hotelId")Integer hotelId);

    Integer getRoomStatusById(@Param("hotelId")Integer hotelId,@Param("roomId")Integer roomId);

    Integer getHotelIdById(@Param("managerId")Integer managerId);

    int updateByBothId(HotelRoomEntity entity);

    Integer getMaxRoomId(@Param("hotelId")Integer hotelId);
}
