package com.rainng.coursesystem.manager.teacher;
import com.rainng.coursesystem.dao.redis.ManagerRoomDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.HotelRoomEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelRoomVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelRoomManager extends BaseManager {
    private final ManagerRoomDAO managerRoomDAO;

    //售后订单管理类
    public HotelRoomManager(ManagerRoomDAO managerOrderDAO) {
        this.managerRoomDAO = managerOrderDAO;
    }

    public List<HotelRoomVO> listHotelRoom(Integer customerId) {
        List<HotelRoomVO> a=managerRoomDAO.listHotelRoom(customerId);
        System.out.println(a);
        return a;
    }

    public int createRoom(HotelRoomEntity hotelRoomEntity){
        return managerRoomDAO.insertRoom(hotelRoomEntity);
    }

    public int getHotelIdById(Integer managerId){
        return managerRoomDAO.getHotelIdById(managerId);
    }

    public int getRoomId(Integer hotelId){
        return managerRoomDAO.getRoomId(hotelId);
    }

    public int deleteRoom(Integer roomId){
        return managerRoomDAO.deleteRoom(roomId);
    }

    public int getRoomStatus(Integer roomId){
        return managerRoomDAO.getRoomStatus(roomId);
    }


}
