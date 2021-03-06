package com.rainng.coursesystem.dao.redis;

import com.rainng.coursesystem.dao.BaseDAO;
import com.rainng.coursesystem.dao.mapper.ManagerRoomMapper;
import com.rainng.coursesystem.model.entity.HotelRoomEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelRoomVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerRoomDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final ManagerRoomMapper mapper;

    public ManagerRoomDAO(ManagerRoomMapper mapper) {
        this.mapper = mapper;
    }

    public List<HotelRoomVO> listHotelRoom(Integer customerId) {
        return mapper.listHotelRoom(customerId);
    }

    public int insertRoom(HotelRoomEntity entity) {
        return mapper.insert(entity);
    }

    public int updateRoom(HotelRoomEntity entity) {
        return mapper.updateByBothId(entity);
    }

    public int deleteRoom(Integer hotelId,Integer roomId) {
        return mapper.deleteRoomById(hotelId,roomId);
    }

    public int decreaseRoom(Integer hotelId){
        return mapper.decreaseRoomByHotelId(hotelId);
    }

    public int increaseRoom(Integer hotelId){
        return mapper.increaseRoomByHotelId(hotelId);
    }



    public Integer getHotelIdById(Integer managerId){
        return mapper.getHotelIdById(managerId);
    }

    public Integer getRoomId(Integer hotelId){
        return mapper.getMaxRoomId(hotelId);
    }

    public Integer getRoomStatus(Integer hotelId,Integer roomId){
        return mapper.getRoomStatusById(hotelId,roomId);
    }
}
