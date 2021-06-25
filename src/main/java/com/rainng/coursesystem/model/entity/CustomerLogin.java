package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

//@TableName("ht_customer")
@Data
public class CustomerLogin {
    private String customer_name;
    private String customer_password;
    private String customer_email;
    private String customer_tel;

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


//    public static final String ID = "customer_id";
//    public static final String TEL = "customer_tel";
//    public static final String EMAIL = "customer_email";
//    public static final String NAME = "customer_name";
//    public static final String PASSWORD = "customer_password";
//    public static final String BIRTHDAY = "customer_birthday";
//    public static final String SEX = "customer_sex";
//    public static final String LAST_IN = "customer_last_login_time";
//    public static final String CITY = "customer_city";
//    @NotNull
//    @TableId(value = ID, type = IdType.AUTO)
//    private Integer customer_id;
//
//    @NotNull
//    @Length(min = 11, max = 11,message = "填写手机号！")
//    @TableField(TEL)
//    private Integer customer_tel;
//
//    @NotBlank(message = "姓名不能为空")
//    @TableField(NAME)
//    private String customer_name;
//
//    @NotNull
//    @Email(message = "邮箱格式不正确")
//    @TableField(value = EMAIL, updateStrategy = FieldStrategy.IGNORED)
//    private String customer_email;
//
//    @NotNull
//    @TableField(PASSWORD)
//    private String customer_password;
//
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @TableField(value = BIRTHDAY, updateStrategy = FieldStrategy.IGNORED)
//    private Date birthday;
//
//    @Range(min = 0, max = 1)
//    @TableField(SEX)
//    private Integer sex;
//
//    @TableField(LAST_IN)
//    private Date lastLoginTime;
//
//    public Integer getId() { return customer_id; }
//
//    public void setId(Integer customer_id) { this.customer_id = customer_id; }
//
//    public String getEmail() { return customer_email; }
//
//    public void setEmail(String customer_email){this.customer_email = customer_email;}
//
//    public String getName() {return  customer_name;}
//
//    public void setName(String customer_name){this.customer_name = customer_name;}
//
//    public Integer getTel(){return customer_tel;}
//
//    public void setTel (Integer customer_tel) { this.customer_tel = customer_tel; }
//
//    public String getCustomer_password() {
//    }
//}
