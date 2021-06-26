package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.HotelRoomEntity;
import com.rainng.coursesystem.model.vo.request.HotelInfoVO;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerHotelMapper extends BaseMapper<HotelRoomEntity> {

    HotelInfoVO getHotelInfoByManagerId(Integer managerId);
}
