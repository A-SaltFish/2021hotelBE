package com.rainng.coursesystem.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.ManagerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerOrderMapper extends BaseMapper<ManagerOrderEntity> {

    IPage<HotelAllOrderItemVO> getPage(IPage<HotelAllOrderItemVO> page, @Param("managerId")Integer managerId);

    Integer getHotelIdByManagerId(Integer managerId);
}
