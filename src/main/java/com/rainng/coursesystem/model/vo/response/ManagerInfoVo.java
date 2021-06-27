package com.rainng.coursesystem.model.vo.response;

import lombok.Data;

import java.util.Date;

@Data
public class ManagerInfoVo {
    private Integer managerId;
	private Integer hotelId;
    private String name;	//昵称
    private String tel;	//电话
    private String email;

    private String password;
	private String desc;
	private Integer available;

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getDesc() {
		return desc;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public String getTel() {
		return tel;
	}
	public void setTel(String Tel) {
		this.tel = Tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
