package com.rainng.coursesystem.dao.mapper;


import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface CustomerOrderMapper {
    int insertByOid(Integer id, Integer customerId, Integer hotelId, Integer roomId, Integer ctime, Integer status, Integer ifShow, String reason);
}
