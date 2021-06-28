package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Manager;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.teacher.HotelPreOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Manager
@RequestMapping("/manager/preorder")
@RestController("hotel_preorder_Controller")
public class HotelPreOrderController extends BaseController {
    private final HotelPreOrderService service;

    public HotelPreOrderController(HotelPreOrderService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        System.out.println("经理端 酒店当前订单 获取");
        return service.list();
    }
}
