package com.rainng.coursesystem.controller;

import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller

public class CustomerController {
    @Autowired(required = false)
    private CustomerService customerService;
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register2(@RequestParam("customer_name") String customer_name,@RequestParam("customer_password") String customer_password,@RequestParam("customer_email") String customer_email,@RequestParam("customer_tel") String customer_tel){
        CustomerEntity checkemail = customerService.findemail(customer_email);//查询数据库里是否有相同的邮箱
        CustomerEntity checkname = customerService.findname(customer_name);

        if (checkemail != null){
            return "email has existed";
        }

        else if(checkname != null){
            return "name has existed";
        }

        else{
            //创建用户对象，并赋值保存
            CustomerEntity customer = new CustomerEntity();
            Date now = new Date();//获取时间
//            Integer customer_id = UUID.randomUUID().toString();//创建一个唯一标志id
//            customer.setCustomer_id(customer_id);
            customer.setCustomer_name(customer_name);
            customer.setCustomer_email(customer_email);
            customer.setCustomer_password(customer_password);
            customer.setCustomer_tel(customer_tel);
            customerService.register(customer);
            return "index";
        }
    }
    @PostMapping("/login")
    @ResponseBody
    public String login2(@RequestBody Map map){
        System.out.println("准备登录");
        CustomerEntity customer = customerService.login(map.get("customer_name").toString(), map.get("customer_password").toString());
        System.out.println(map);
        if(customer != null){
            return "index";
        }
        else {
            return "login";
        }
    }
    }
