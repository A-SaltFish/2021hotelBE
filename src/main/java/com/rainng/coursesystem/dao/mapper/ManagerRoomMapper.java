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

    int deleteRoomById(@Param("roomId")Integer roomId);

    Integer getRoomStatusById(@Param("roomId")Integer roomId);

    Integer getHotelIdById(@Param("managerId")Integer managerId);

    Integer getMaxRoomId(@Param("managerId")Integer managerId);
}
