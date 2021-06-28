package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Manager;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.teacher.HotelAllOrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Manager
@RequestMapping("/manager/allorder")
@RestController("hotel_allorder_controller")
public class HotelAllOrderController extends BaseController {
    private final HotelAllOrderService service;

    @RequestMapping("/page/count")
    public ResultVO getPageCount(Integer Id) {
        System.out.println("酒店全部订单Page数获取");
        return service.getPageCount(Id);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index) {
        System.out.println("酒店全部订单当前Page获取");
        return service.getPage(index);
    }

    public HotelAllOrderController(HotelAllOrderService service) {
        this.service = service;
    }

    //@RequestMapping
    //public ResultVO get() {
    //    return service.get();
   // }
}
