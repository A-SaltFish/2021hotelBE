package com.rainng.coursesystem.dao.mapper;


import com.rainng.coursesystem.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
    /**
     * 注册，插入数据
     */

    void insertUser(User custormer_user);

    /**
     * 根据邮箱查询
     */
    User queryByEmail(String custormer_email);
}
