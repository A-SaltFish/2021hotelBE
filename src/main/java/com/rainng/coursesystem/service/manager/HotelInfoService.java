package com.rainng.coursesystem.service.manager;

import com.rainng.coursesystem.manager.manager.HotelInfoManager;
import com.rainng.coursesystem.model.vo.request.HotelInfoVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class HotelInfoService extends BaseService {

    private final HotelInfoManager manager;

    public HotelInfoService(HotelInfoManager manager) {
        this.manager = manager;
    }

    public ResultVO get() {
        return result(manager.getHotelInfoByManagerId(getUserId()));
    }

    public ResultVO updateHotel(@RequestBody @Validated HotelInfoVO hotelInfoVO) {
        manager.updateHotel(hotelInfoVO);
        Integer managerId=getUserId();
        System.out.println(hotelInfoVO);
        manager.updatePassword(managerId,hotelInfoVO.getPassword());
        return result("更新成功");
    }
}
