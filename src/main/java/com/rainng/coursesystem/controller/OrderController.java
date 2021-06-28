package com.rainng.coursesystem.controller;


import com.rainng.coursesystem.model.entity.OrderEntity;
import com.rainng.coursesystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/order")
    public String OrderInfo(@RequestParam("order_cost") Integer order_cost,@RequestParam("customerId") Integer customerId, @RequestParam("hotelId") Integer hotelId, @RequestParam("roomId") Integer roomId, @RequestParam("status") Integer status, @RequestParam("ifShow") Integer ifShow){
        System.out.println("插入訂單功能");
        OrderEntity order = new OrderEntity();
        Date now = new Date();
//        new Date(order.setCtime(ctime));
        order.setOrder_cost(order_cost);
        order.setCustomerId(customerId);
        order.setHotelId(hotelId);
        order.setRoomId(roomId);
//        order.setCtime((java.sql.Date) ctime);
        order.setStatus(status);
        order.setIfShow(ifShow);
//        order.setReason(reason);
        orderService.insertOrder(order);
        System.out.println(order.roomId);
        return "success";
    }

}
