package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Manager;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.request.HotelInfoVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.teacher.HotelInfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Manager
@RequestMapping("/manager/info")
@RestController
public class HotelInfoController extends BaseController {
    private final HotelInfoService service;

    public HotelInfoController(HotelInfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated HotelInfoVO formVO) {
        return service.updateHotel(formVO);
    }
}
