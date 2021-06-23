package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Teacher;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.teacher.HotelAllOrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/manager/allorder")
@RestController
public class HotelAllOrderController extends BaseController {
    private final HotelAllOrderService service;

    @RequestMapping("/page/count")
    public ResultVO getPageCount(Integer Id) {
        return service.getPageCount(Id);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index) {
        return service.getPage(index);
    }

    public HotelAllOrderController(HotelAllOrderService service) {
        this.service = service;
    }

    @RequestMapping
    public ResultVO get() {
        return service.get();
    }
}
