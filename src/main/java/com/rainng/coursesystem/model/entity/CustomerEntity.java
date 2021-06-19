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

@TableName("ht_customer")
@Data
public class CustomerEntity {
    public static final String ID = "customer_id";
    public static final String TEL="customer_tel";
    public static final String NAME = "customer_name";
    public static final String PASSWORD = "customer_password";
    public static final String EMAIL = "customer_email";
    public static final String BIRTHDAY = "customer_birthday";
    public static final String SEX = "customer_sex";
    public static final String CITY= "customer_city";
    public static final String LAST_LOGIN_TIME = "customer_last_login_time";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @Length(min=13,max=13,message = "手机号码长度必须为13位")
    @TableField(TEL)
    private String tel;

    @NotBlank(message = "学生姓名不能为空")
    @TableField(NAME)
    private String name;

    @NotNull
    @TableField(PASSWORD)
    private String password;

    @Email(message = "邮箱格式不正确")
    @TableField(value = EMAIL, updateStrategy = FieldStrategy.IGNORED)
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = BIRTHDAY, updateStrategy = FieldStrategy.IGNORED)
    private Date birthday;

    @Range(min = 0, max = 1)
    @TableField(SEX)
    private Integer sex;

    @TableField(LAST_LOGIN_TIME)
    private Date lastLoginTime;

	@TableField(CITY)
	private String city;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
    
    
}
