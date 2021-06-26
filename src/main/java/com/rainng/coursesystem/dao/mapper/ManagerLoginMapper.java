package com.rainng.coursesystem.dao.mapper;


import com.rainng.coursesystem.model.entity.ManagerLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ManagerLoginMapper {
    void insertManager(ManagerLogin managerLogin);

    ManagerLogin queryByEmail(String manager_email);
}
