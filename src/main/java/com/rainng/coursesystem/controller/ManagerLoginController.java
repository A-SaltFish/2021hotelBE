package com.rainng.coursesystem.controller;


import com.rainng.coursesystem.model.vo.CustomerLoginVo;
import com.rainng.coursesystem.model.vo.ManagerLoginVo;
import com.rainng.coursesystem.service.MailService;
import com.rainng.coursesystem.service.ManagerMailService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ManagerLoginController {
    @Autowired
    private ManagerMailService managerMailService;


    @PostMapping("/Manager_regist")
    @ResponseBody
    public String register(ManagerLoginVo managerLoginVo, HttpSession session){
        managerMailService.mgregistered(managerLoginVo,session);
//        System.out.println(userVo);
        return "success";
    }

    @PostMapping("/Manager_login")
    @ResponseBody
    public String login(String manager_email,String manager_password){
        managerMailService.loginIn(manager_email,manager_password);
//        System.out.println(customer_email);
        return "success";
    }
}
