package com.rainng.coursesystem.controller.customer;

import com.rainng.coursesystem.config.themis.annotation.Customer;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.customer.OrderSelectService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Customer
@RequestMapping("/student/course/select")
@RestController
public class OrderSelectController extends BaseController {
    private final OrderSelectService service;

    public OrderSelectController(OrderSelectService service) {
        this.service = service;
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(Integer Id) {
        System.out.println("获取页码数");
        return service.getPageCount(Id);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index) {
        System.out.println("获取index页");
        return service.getPage(index);
    }

    @PostMapping("/{id}")
    public ResultVO showOrder(@PathVariable Integer id) {
        return service.showOrder(id);
    }

    @PostMapping("/delete/{id}")
    public ResultVO deleteOrder(@PathVariable Integer id) {
        return service.deleteOrder(id);
    }
}
