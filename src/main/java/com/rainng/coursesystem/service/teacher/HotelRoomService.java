package com.rainng.coursesystem.service.teacher;

import com.rainng.coursesystem.manager.teacher.HotelRoomManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

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

    public ResultVO deleteRoom(Integer roomId){
        if (manager.deleteRoom(roomId)>0)
            return result("退单成功！");
        else return result("退单失败！");
    }
}
