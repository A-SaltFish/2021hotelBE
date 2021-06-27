package com.rainng.coursesystem.controller;

import com.rainng.coursesystem.dao.mapper.CustomerOrderMapper;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.service.CustomerOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/order")
public class CustomerOrderController {
    @Autowired
//    private CustomerOrderService customerOrderService;
    private CustomerOrderMapper customerOrderMapper;

    @RequestMapping("/order1")
    public void insert(CustomerOrderEntity customerOrderEntity){
        customerOrderMapper.insertByOid(customerOrderEntity);
    }
//    @PostMapping("/insertByOid")
//    public int insertByOid(Integer id, Integer customerId, Integer hotelId, Integer roomId, Integer ctime, Integer status, Integer ifShow, String reason){
//        customerOrderService.insertByOid(id, customerId, hotelId, roomId, ctime, status, ifShow, reason);
//        //System.out.println((customerOrderEntity));
//        return 0;
//    }

//    public List<CustomerOrderEntity> insertByOid(@Param("id") Integer id){
//        List<CustomerOrderEntity> list = customerOrderService.insertByOid(id);
//        System.out.println(list);
//        return list;
//    }


}
