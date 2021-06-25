package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Teacher;
import com.rainng.coursesystem.model.vo.TeacherGradeVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.teacher.HotelAfterSalesService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Teacher
@RequestMapping("/manager/aftersales")
@RestController
public class HotelAfterSalesController {
    private final HotelAfterSalesService service;

    public HotelAfterSalesController(HotelAfterSalesService service) {
        this.service = service;
    }

    @RequestMapping("/page/count")
    public ResultVO getPageCount(Integer orderId,String hotelName) {
        System.out.println("售后服务 退单订单Page数目获取");
        return service.getPageCount(orderId, hotelName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index, String courseName, String studentName) {
        return service.getPage(index, courseName, studentName);
    }

    @GetMapping("/{id}")
    public ResultVO get(@PathVariable Integer id) {
        return service.get(id);
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated TeacherGradeVO vo) {
        return service.update(vo);
    }
}