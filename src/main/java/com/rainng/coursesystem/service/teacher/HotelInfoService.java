package com.rainng.coursesystem.service.teacher;

import com.rainng.coursesystem.manager.student.InfoManager;
import com.rainng.coursesystem.manager.teacher.HotelInfoManager;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.request.CustomerInfoFormVO;
import com.rainng.coursesystem.model.vo.request.HotelInfoVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.service.UserService;
import org.springframework.beans.BeanUtils;
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

    public ResultVO update(@RequestBody @Validated HotelInfoVO studentInfoForm) {
        return result("更新成功");
    }
}
