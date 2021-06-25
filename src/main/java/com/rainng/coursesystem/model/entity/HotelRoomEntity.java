package com.rainng.coursesystem.model.entity;

import lombok.Data;
import com.rainng.coursesystem.model.vo.request.RoomInfoVO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@TableName("ht_room")
@Data
public class HotelRoomEntity {
	private static final String HOTELID = "rm_hotel_id";
	private static final String ROOMID = "room_id";
	private static final String TYPE = "room_type";
	private static final String DESC = "room_describe";
	private static final String IMG = "room_img";
	private static final String ORDERID = "rm_order_id";
	private static final String STATUS = "room_status";
	private static final String BREAKFAST = "rm_breakfast_type";
	private static final String PRICE = "room_price";

	@NotNull
	@TableId(value = HOTELID, type = IdType.INPUT)
	private Integer hotelId;

	@NotNull
	@TableId(value = ROOMID, type = IdType.INPUT)
	private Integer roomId;

	@TableField(ORDERID)
	private Integer orderId;

	@NotBlank
	@TableField(TYPE)
	private String type;

	@TableField(DESC)
    private String desc;

	@TableField(IMG)
    private String img;

	@NotNull
	@TableField(STATUS)
    private Integer status;

    @NotNull
	@TableField(PRICE)
	private Integer price;

	@TableField(BREAKFAST)
	private String breakfast;

	HotelRoomEntity(RoomInfoVO roomInfoVO){
		this.hotelId=roomInfoVO.getHotelId();
		this.roomId=roomInfoVO.getRoomId();
		this.breakfast=roomInfoVO.getBreakfast();
		this.desc=roomInfoVO.getDesc();
		this.img=roomInfoVO.getImg();
		this.orderId=0;
		this.price=roomInfoVO.getPrice();
		this.status=roomInfoVO.getStatus();
		this.type=roomInfoVO.getType();
	}


	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
