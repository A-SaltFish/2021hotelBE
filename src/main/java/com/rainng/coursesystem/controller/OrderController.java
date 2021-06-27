package com.rainng.coursesystem.controller;


import com.rainng.coursesystem.model.entity.Order;
import com.rainng.coursesystem.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/order")
    public Order insert(Order order){
        return orderService.insertOrder(order);
    }

}
