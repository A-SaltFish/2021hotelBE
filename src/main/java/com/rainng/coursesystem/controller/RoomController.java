package com.rainng.coursesystem.controller;


import com.rainng.coursesystem.model.entity.Room;
import com.rainng.coursesystem.service.RoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roominfo")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<Room> getHid(@Param("rm_hotel_id") Integer rm_hotel_id){
        List<Room> list = roomService.findByHid(rm_hotel_id);
        System.out.println("11111111111111");
        System.out.println(list);
        return list;

    }


}
