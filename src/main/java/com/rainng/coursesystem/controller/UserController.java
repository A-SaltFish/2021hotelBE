package com.rainng.coursesystem.controller;

import com.rainng.coursesystem.model.vo.UserVo;
import com.rainng.coursesystem.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private MailService mailService;

    @PostMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(String email,HttpSession httpSession){
        mailService.sendMimeMail(email,httpSession);
        return "sucess";
    }

    @PostMapping("/regist")
    @ResponseBody
    public String regist(UserVo userVo, HttpSession session){
        mailService.registered(userVo,session);
        return "success";
    }

    @PostMapping("login")
    @ResponseBody
    public String login(String email,String password){
        mailService.loginIn(email,password);
        return "success";
    }

}
