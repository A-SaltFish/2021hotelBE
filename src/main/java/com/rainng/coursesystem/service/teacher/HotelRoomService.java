package com.rainng.coursesystem.service.teacher;

import com.rainng.coursesystem.manager.teacher.HotelRoomManager;
import com.rainng.coursesystem.model.vo.request.RoomInfoVO;
import com.rainng.coursesystem.model.entity.HotelRoomEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service("manager_roomService")
public class HotelRoomService extends BaseService {
    private final HotelRoomManager manager;

    public HotelRoomService(HotelRoomManager manager) {
        this.manager = manager;
    }

    public ResultVO list() {
        Integer managerId = getUserId();
        return result(manager.listHotelRoom(managerId));
    }

    public ResultVO createRoom(@RequestBody @Validated HotelRoomEntity roomInfoForm){
        Integer managerId=getUserId();
        Integer hotelId=manager.getHotelIdById(managerId);
        Integer roomId=manager.getRoomId(hotelId)+1;
        roomInfoForm.setHotelId(hotelId);
        roomInfoForm.setRoomId(roomId);
        return result(manager.createRoom(roomInfoForm));
    }

    public ResultVO deleteRoom(Integer roomId){
        if (manager.getRoomStatus(roomId)!=1&&manager.deleteRoom(roomId)>0)
            return result("退单成功！");
        else return result("退单失败！");
    }
}
