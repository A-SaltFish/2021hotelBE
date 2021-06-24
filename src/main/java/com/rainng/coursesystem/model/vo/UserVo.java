package com.rainng.coursesystem.model.vo;


import lombok.Data;

@Data
public class UserVo {
    private String customer_name;

    private String customer_password;

    private String customer_email;

    private String customer_tel;
    //    验证码
    private String code;
}
