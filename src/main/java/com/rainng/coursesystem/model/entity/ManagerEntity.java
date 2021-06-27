package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
	@TableField(TEL)
	private String tel;	//电话
	@TableField(EMAIL)
	private String email;
	@TableField(DESC)
	private String desc;
	@TableField(AVAILABLE)
	private Integer available;

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


	public void setPassword(String password) {
		this.password = password;
	}
    
}
