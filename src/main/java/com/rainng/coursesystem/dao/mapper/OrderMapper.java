package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.bo.OrderItemBo;
import com.rainng.coursesystem.model.bo.StudentCourseSelectItemBO;
import com.rainng.coursesystem.model.entity.OrderEntity;
import com.rainng.coursesystem.model.vo.response.table.OrderItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<OrderEntity> {
    Integer count(@Param("departmentName")String departmentName, @Param("teacherName")String teacherName, @Param("name")String name);

    IPage<OrderItemBo> getPage(IPage<OrderItemBo> page, @Param("departmentName")String departmentName, @Param("teacherName")String teacherName, @Param("name")String name);

    OrderItemVO getExplicitOrderById(@Param("orderId")Integer orderId);


}
