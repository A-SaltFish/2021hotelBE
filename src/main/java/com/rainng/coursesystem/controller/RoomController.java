package com.rainng.coursesystem.controller;


import com.rainng.coursesystem.model.entity.Room;
import com.rainng.coursesystem.service.RoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roominfo")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public Room getInfo(@Param("rm_hotel_id") Integer rm_hotel_id, Integer room_id, String room_type, String room_img, Integer room_status, Integer rm_order_id,Integer rm_breakfast_type) {
        Room room = roomService.findByHid(rm_hotel_id,room_id,room_type,room_img,room_status,rm_order_id,rm_breakfast_type);
        return room;
    }


}
