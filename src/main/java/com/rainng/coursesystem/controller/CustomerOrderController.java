package com.rainng.coursesystem.controller;

import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping("/insertByOid")
    public int insertByOid(Integer id, Integer customerId, Integer hotelId, Integer roomId, Integer ctime, Integer status, Integer ifShow, String reason){
        customerOrderService.insertByOid(id, customerId, hotelId, roomId, ctime, status, ifShow, reason);
        //System.out.println((customerOrderEntity));
        return 0;
    }

}
