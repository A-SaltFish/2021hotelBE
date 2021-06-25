package com.rainng.coursesystem.model.vo;


import lombok.Data;

@Data
public class CustomerLoginVo {
    private String customer_name;

    private String customer_password;

    private String customer_email;

    private String customer_tel;
    //    验证码
    private String code;


    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() { return customer_email; }

    public void setCustomer_email(String customer_email) { this.customer_email = customer_email; }

    public String getCusotmer_tel() {return customer_tel;}

    public void setCustomer_tel(String customer_tel) { this.customer_tel = customer_tel; }
}
