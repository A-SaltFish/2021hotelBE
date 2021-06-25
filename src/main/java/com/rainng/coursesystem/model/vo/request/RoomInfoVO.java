package com.rainng.coursesystem.model.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class RoomInfoVO {
	private Integer hotelId;
	private Integer roomId;
	//手机号码要为11位
	@NotBlank
	private String type;
    private String desc;
    private String img="";
    private Integer status=1;
    private String breakfast;
    @NotNull
	private Integer price;

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getType() {
		return type;
	}

	public String getImg() {
		return img;
	}

	public Integer getStatus() {
		return status;
	}

	public String getDesc() {
		return desc;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
}
