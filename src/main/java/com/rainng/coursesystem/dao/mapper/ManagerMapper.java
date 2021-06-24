package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelPreOrderItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherItemVO;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerMapper extends BaseMapper<ManagerEntity> {
    Integer count(@Param("departmentName")String departmentName, @Param("name")String name);

    IPage<HotelAllOrderItemVO> getPage(IPage<TeacherItemVO> page, @Param("managerId")Integer managerId);

    Integer getHotelIdByManagerId(Integer managerId);

    List<HotelAllOrderItemVO> listTeacherTimetable(Integer teacherId);

    List<HotelPreOrderItemVO> HotelPreList(Integer managerId);
}
