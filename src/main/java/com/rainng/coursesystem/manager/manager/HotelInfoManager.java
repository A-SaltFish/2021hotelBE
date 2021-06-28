package com.rainng.coursesystem.manager.manager;

import com.rainng.coursesystem.dao.HotelDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.request.HotelInfoVO;
import org.springframework.stereotype.Component;

@Component
public class HotelInfoManager extends BaseManager {
    private final HotelDAO hotelDAO;

    public HotelInfoManager(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    public HotelInfoVO getHotelInfoByManagerId(Integer managerId) {
        return hotelDAO.getHotelInfoByManagerId(managerId);
    }

    public int updateHotel(HotelInfoVO hotelInfoVO){
        return hotelDAO.updateHotelInfo(hotelInfoVO);
    }

    public int updatePassword(Integer managerId,String password){
        return hotelDAO.updatePassword(managerId,password);
    }

}
