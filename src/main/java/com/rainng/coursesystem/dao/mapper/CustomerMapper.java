package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.CustomerInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper extends BaseMapper<CustomerEntity> {

    Integer count(@Param("majorName")String majorName,@Param("className") String className, @Param("name")String name);

    //分页查询？
    CustomerInfoVo getCustomerInfoById(Integer studentId);
}
