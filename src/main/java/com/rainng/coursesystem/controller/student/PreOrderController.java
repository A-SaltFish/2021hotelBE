package com.rainng.coursesystem.controller.student;

import com.rainng.coursesystem.config.themis.annotation.Student;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.student.OrderService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//对应前端页面的student的preorder页面，用于操纵用户进行中 的订单
@Student
@RequestMapping("/student/course")
@RestController("student_courseController")
public class PreOrderController extends BaseController {
    private final OrderService service;

    public PreOrderController(OrderService service) {
        this.service = service;
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }

    @DeleteMapping("/{id}")
    public ResultVO cancelOrder(@PathVariable Integer id) {
        return service.cancelOrder(id);
    }
}
