package com.rainng.coursesystem.model.vo.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class HotelInfoVO {
	@NotBlank
	private Integer hotelId;
	@NotBlank
	private Integer managerId;
	@NotBlank
	private String name;
	//手机号码要为11位
	@Length(min=11,max=11)
	private String tel;

    private String desc;

    private Integer isOpen;

	private String password;

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
    
}
