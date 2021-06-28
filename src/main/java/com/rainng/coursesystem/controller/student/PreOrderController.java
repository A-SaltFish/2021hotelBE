package com.rainng.coursesystem.controller.student;

import com.rainng.coursesystem.config.themis.annotation.Customer;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.student.OrderService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//对应前端页面的student的preorder页面，用于操纵用户进行中 的订单
@Customer
@RequestMapping("/customer/preOrder")
@RestController("customer_preOrderController")
public class PreOrderController extends BaseController {
    private final OrderService service;

    public PreOrderController(OrderService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        System.out.println("开始获取当前订单");
        return service.list();
    }

    @RequestMapping("/refund")
    public ResultVO refund( Integer orderId,String reason) {
        System.out.println("开始申请退款");
        return service.refund(orderId,reason);
    }

    @RequestMapping("/remark")
    public ResultVO refund( Integer orderId,String comment,Integer rank) {
        System.out.println("评价订单");
        return service.remark(orderId,comment,rank);
    }

    @DeleteMapping("/{id}")
    public ResultVO cancelOrder(@PathVariable Integer id) {
        return service.cancelOrder(id);
    }
}
