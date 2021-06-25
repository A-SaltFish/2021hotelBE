package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Teacher;
import com.rainng.coursesystem.model.entity.HotelRoomEntity;
import com.rainng.coursesystem.model.vo.request.RoomInfoVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.teacher.HotelRoomService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/manager/room")
@RestController
public class HotelRoomController {
    private final HotelRoomService service;

    public HotelRoomController(HotelRoomService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }

    @PutMapping("/create")
    public ResultVO createRoom(@RequestBody @Validated HotelRoomEntity roomVO) {
        return service.createRoom(roomVO);
    }

    @RequestMapping("/delete")
    public ResultVO deleteRoom(Integer roomId){
        return service.deleteRoom(roomId);
    }
}
