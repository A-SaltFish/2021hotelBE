package com.rainng.coursesystem.controller;

import com.rainng.coursesystem.model.vo.UserVo;
import com.rainng.coursesystem.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private MailService mailService;

    @PostMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(String customer_email,HttpSession httpSession){
//        System.out.println(customer_email);
        mailService.sendMimeMail(customer_email,httpSession);
        return "success";
    }

    @PostMapping("/regist")
    @ResponseBody
    public String regist(UserVo userVo, HttpSession session){
        mailService.registered(userVo,session);
//        System.out.println(userVo);
        return "success";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(String customer_email,String customer_password){
        mailService.loginIn(customer_email,customer_password);
        return "success";
    }

}
