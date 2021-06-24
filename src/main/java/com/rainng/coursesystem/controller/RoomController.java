package com.rainng.coursesystem.controller;


import com.rainng.coursesystem.model.entity.Room;
import com.rainng.coursesystem.service.RoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/getInfo")
    public Integer getInfo(@Param("rm_hotel_id") Integer rm_hotel_id) {
        Room room = roomService.findByHid(rm_hotel_id);
        return room.getRoom_id();
    }


}
