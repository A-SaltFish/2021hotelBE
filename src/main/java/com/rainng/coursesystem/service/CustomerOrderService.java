package com.rainng.coursesystem.service;

import com.rainng.coursesystem.model.entity.CustomerOrderEntity;

import java.util.List;

public interface CustomerOrderService {
     public List<CustomerOrderEntity> insertByOid(Integer id);
//             int insertByOid(Integer id, Integer customerId, Integer hotelId, Integer roomId, Integer ctime, Integer status, Integer ifShow, String reason);
}
