package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@TableName("ht_manager")
@Data
public class ManagerEntity {
    public String getPassword() {
		return password;
	}

	public static final String ID = "manager_id";
    public static final String NAME = "manager_name";
    public static final String PASSWORD = "manager_password";
    public static final String HOTELID="mg_hotel_id";
    public static final String TEL="manager_tel";
	public static final String EMAIL="manager_email";
	public static final String DESC="manager_describe";
	public static final String AVAILABLE="manager_available";

    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "经理姓名不能为空")
    @TableField(NAME)
    private String name;

    @TableField(HOTELID)
	private Integer hotelId;

	@Length(min=11,max=11,message="经理手机必须为11位数")
	@TableField(TEL)
	private String tel;	//电话

	@Email(message = "邮箱格式不正确")
	@TableField(value = EMAIL, updateStrategy = FieldStrategy.IGNORED)
	private String email;

	@TableField(DESC)
	private String description="普通的一个经理";

	@TableField(AVAILABLE)
	private Integer available=0;

    @NotNull
    @TableField(PASSWORD)
    private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}
