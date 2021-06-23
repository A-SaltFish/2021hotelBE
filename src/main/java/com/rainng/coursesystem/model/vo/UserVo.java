package com.rainng.coursesystem.model.vo;


import lombok.Data;

@Data
public class UserVo {
    private String custormer_username;

    private String custormer_password;

    private String custormer_email;
    //    验证码
    private String code;
}
