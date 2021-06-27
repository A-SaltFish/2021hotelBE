package com.rainng.coursesystem.service.impl;

import com.rainng.coursesystem.dao.mapper.OrderMapper;
import com.rainng.coursesystem.model.entity.Order;
import com.rainng.coursesystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order insertOrder(Order order){orderMapper.insertOrder(order);return order;}
}
