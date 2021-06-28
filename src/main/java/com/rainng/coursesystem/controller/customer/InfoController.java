package com.rainng.coursesystem.controller.customer;

import com.rainng.coursesystem.config.themis.annotation.Customer;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.request.CustomerInfoFormVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.customer.InfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Customer
@RequestMapping("/customer/info")
@RestController
public class InfoController extends BaseController {
    private final InfoService service;

    public InfoController(InfoService service) {
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
