package com.rainng.coursesystem.model.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class HotelInfoVO {
	@NotNull
	private Integer hotelId;
	@NotNull
	private Integer managerId;
	@NotBlank
	private String name;
	//手机号码要为11位
	@Length(min=11,max=11,message = "手机号必须为11位")
	private String tel;

    private String desc;

    private Integer isOpen;

	private String password;

	public Integer getHotelId() {
		return hotelId;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public Integer getIsOpen() {
		return isOpen;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getManagerId() {
		return managerId;
	}
}
