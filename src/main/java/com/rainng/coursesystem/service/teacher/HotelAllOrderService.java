package com.rainng.coursesystem.service.teacher;

import com.rainng.coursesystem.manager.teacher.HotelAllOrderManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelAllOrderService extends BaseService {
    private final HotelAllOrderManager manager;

    public HotelAllOrderService(HotelAllOrderManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(Integer Id) {
        Integer customerId = getUserId();
        return result(manager.getPageCount(customerId));
    }

    public ResultVO getPage(Integer index) {
        Integer managerId = getUserId();
        List<HotelAllOrderItemVO> boList = manager.getPage(index, managerId);

        return result(boList);
    }

}
