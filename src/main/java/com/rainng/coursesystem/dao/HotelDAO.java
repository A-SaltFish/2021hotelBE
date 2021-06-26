package com.rainng.coursesystem.dao;


import com.rainng.coursesystem.dao.mapper.ManagerHotelMapper;
import com.rainng.coursesystem.model.vo.request.HotelInfoVO;
import org.springframework.stereotype.Repository;


@Repository
public class HotelDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final ManagerHotelMapper mapper;

    public HotelDAO(ManagerHotelMapper mapper){
        this.mapper=mapper;
    }

    public HotelInfoVO getHotelInfoByManagerId(Integer managerId) {
        return mapper.getHotelInfoByManagerId(managerId);
    }

    public int updateHotelInfo(HotelInfoVO hotelInfoVO){
        return mapper.updateHotelInfo(hotelInfoVO);
    }

    public int updatePassword(Integer managerId,String password){
        return mapper.updateManagerPassword(managerId,password);
    }

}
