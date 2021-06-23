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

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "经理姓名不能为空")
    @TableField(NAME)
    private String name;

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
