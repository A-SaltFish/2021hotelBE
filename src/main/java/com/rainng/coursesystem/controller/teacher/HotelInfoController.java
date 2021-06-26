package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Student;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.request.CustomerInfoFormVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.student.InfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Student
@RequestMapping("/customer/info")
@RestController
public class HotelInfoController extends BaseController {
    private final InfoService service;

    public HotelInfoController(InfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated CustomerInfoFormVO formVO) {
        return service.update(formVO);
    }
}
