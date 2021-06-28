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
    public String OrderInfo(@RequestParam("id") Integer id, @RequestParam("customerId") Integer customerId, @RequestParam("hotelId") Integer hotelId, @RequestParam("roomId") Integer roomId, @RequestParam("status") Integer status, @RequestParam("ifShow") Integer ifShow,@RequestParam("reason") String reason){
        OrderEntity order = new OrderEntity();
        Date now = new Date();
        order.setId(id);
        order.setCustomerId(customerId);
        order.setHotelId(hotelId);
        order.setRoomId(roomId);
//        order.ctime(ctime);
        order.setStatus(status);
        order.setIfShow(ifShow);
        order.setReason(reason);

        orderService.insertOrder(order);
        return "success";
    }

}
