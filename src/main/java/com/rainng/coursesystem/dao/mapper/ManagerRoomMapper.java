package com.rainng.coursesystem.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.ManagerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelRoomVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRoomMapper extends BaseMapper<ManagerOrderEntity> {

    List<HotelRoomVO> listHotelRoom(@Param("managerId")Integer managerId);

    int deleteRoomById(@Param("orderId")Integer orderId);
}
