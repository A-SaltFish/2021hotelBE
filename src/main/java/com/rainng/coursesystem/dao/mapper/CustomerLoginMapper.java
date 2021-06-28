package com.rainng.coursesystem.dao.mapper;


import com.rainng.coursesystem.model.entity.CustomerLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface CustomerLoginMapper {
    /**
     * 注册，插入数据
     */

    void insertUser(CustomerLogin customerLogin);

    /**
     * 根据邮箱查询
     */
    CustomerLogin queryByEmail(@Param("customer_email") String customer_email);
}
