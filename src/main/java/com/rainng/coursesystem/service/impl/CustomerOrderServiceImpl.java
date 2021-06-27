package com.rainng.coursesystem.service.impl;


import com.rainng.coursesystem.dao.mapper.CustomerOrderMapper;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    private CustomerOrderMapper customerOrderMapper;


//    @Override
//    public int insertByOid(Integer id, Integer customerId, Integer hotelId, Integer roomId, Integer ctime, Integer status, Integer ifShow, String reason) {
//        return customerOrderMapper.insertByOid(id, customerId, hotelId, roomId, ctime, status, ifShow, reason);
//    }

    public List<CustomerOrderEntity> insertByOid(CustomerOrderEntity customerOrderEntity){
        return customerOrderMapper.insertByOid(customerOrderEntity);
    }

    @Override
    public List<CustomerOrderEntity> insertByOid(Integer id) {
        return null;
    }
}
