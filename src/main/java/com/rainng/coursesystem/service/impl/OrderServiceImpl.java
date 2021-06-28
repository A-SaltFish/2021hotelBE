package com.rainng.coursesystem.service.impl;

import com.rainng.coursesystem.dao.mapper.HomeOrderMapper;
import com.rainng.coursesystem.model.entity.OrderEntity;
import com.rainng.coursesystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    private HomeOrderMapper orderMapper;

    @Override
    public int insertOrder(OrderEntity order){return orderMapper.insertOrder(order);}
}
