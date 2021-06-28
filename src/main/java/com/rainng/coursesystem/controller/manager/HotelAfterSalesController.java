package com.rainng.coursesystem.controller.manager;

import com.rainng.coursesystem.config.themis.annotation.Manager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.manager.HotelAfterSalesService;
import org.springframework.web.bind.annotation.*;

@Manager
@RequestMapping("/manager/aftersales")
@RestController
public class HotelAfterSalesController {
    private final HotelAfterSalesService service;

    public HotelAfterSalesController(HotelAfterSalesService service) {
        this.service = service;
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(Integer orderId,String roomName) {
        System.out.println("售后服务 退单数目获取");
        return service.getPageCount(orderId, roomName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, Integer orderId, String roomName) {
        System.out.println("售后服务 退单Page获取");
        return service.getPage(index, orderId, roomName);
    }

    @RequestMapping("/refund")
    public ResultVO confrimRefund(Integer orderId){
        System.out.println("退款服务");
        return service.refund(orderId);
    }

    @RequestMapping("/judge")
    public ResultVO judgeOrder(Integer orderId){
        System.out.println("申请退单仲裁");
        return service.judge(orderId);
    }

}
