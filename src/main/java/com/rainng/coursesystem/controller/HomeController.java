package com.rainng.coursesystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseController {
    @RequestMapping("/")
    public String hello() {
        return "欢迎来到SCU_Hotel";
    }

    @RequestMapping("/test")
    public Object test() {
        return "Hello";
    }
}
