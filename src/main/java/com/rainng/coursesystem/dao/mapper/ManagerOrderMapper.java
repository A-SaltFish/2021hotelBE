package com.rainng.coursesystem.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.ManagerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.ManagerAllOrderItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerOrderMapper extends BaseMapper<ManagerOrderEntity> {

    IPage<ManagerAllOrderItemVO> getPage(IPage<TeacherItemVO> page, @Param("managerId")Integer managerId);

    Integer getHotelIdByManagerId(Integer managerId)
}
