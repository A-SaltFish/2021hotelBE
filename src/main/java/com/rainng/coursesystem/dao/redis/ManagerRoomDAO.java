package com.rainng.coursesystem.dao.redis;

import com.rainng.coursesystem.dao.BaseDAO;
import com.rainng.coursesystem.dao.mapper.ManagerRoomMapper;
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

    public int deleteRoom(Integer id) {
        return mapper.deleteRoomById(id);
    }
}
