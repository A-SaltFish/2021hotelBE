package com.rainng.coursesystem.service.manager;

import com.rainng.coursesystem.manager.manager.HotelRoomManager;
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
        System.out.println("hotelId为"+hotelId);
        System.out.println("roomId为"+roomId);
        roomInfoForm.setHotelId(hotelId);
        roomInfoForm.setRoomId(roomId);
        roomInfoForm.setStatus(0);
        System.out.println(roomInfoForm);
        if(manager.createRoom(roomInfoForm)>0) {
            manager.increaseRoom(hotelId);
            return result("后端创建成功！");
        }
        else return result("后端创建失败！");
    }

    public ResultVO editRoom(@RequestBody @Validated HotelRoomEntity roomInfoForm){
        Integer managerId=getUserId();
        Integer hotelId=manager.getHotelIdById(managerId);
        roomInfoForm.setHotelId(hotelId);
        int roomId=roomInfoForm.getRoomId();
        if(manager.getRoomStatus(hotelId,roomId)==1)
            return result("进行中无法修改！");
        else if(manager.updateRoom(roomInfoForm)>0)
            return result("后端更改成功！");
        else return result("后端更改失败！");
    }

    public ResultVO deleteRoom(Integer roomId){
        System.out.println("进行房间删除操作："+roomId);
        Integer managerId=getUserId();
        Integer hotelId=manager.getHotelIdById(managerId);
        if (manager.getRoomStatus(hotelId,roomId)==1)
            return result("该房间目前正被使用");
        else if (manager.deleteRoom(hotelId,roomId)>0) {
            manager.decreaseRoom(hotelId);
            return result("删除房间成功！");
        }
        else
            return result("房间删除失败！");
    }
}
