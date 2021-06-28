package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Date;
@TableName("ht_order_form")
public class OrderEntity {
	//public Integer id;
	public Integer customerId;
	public Integer order_cost;
	public Integer hotelId;
	public Integer roomId;
	public Date ctime ;
	public Integer status;
	public Integer ifShow;
	public String reason;



	public Integer getCustomerId(){return customerId;}

	public void setCustomerId(Integer customerId){this.customerId =customerId;}

	public Integer getHotelId(){return hotelId;}

	public void setHotelId(Integer hotelId){this.hotelId = hotelId;}

	public Integer getRoomId() {return roomId;}

	public void setRoomId(Integer roomId) {this.roomId = roomId;}

	public Date getCtime(){return ctime;}

	public void setCtime(Date ctime){this.ctime = ctime;}

	public Integer getStatus(){return  status;}

	public void setStatus(Integer status){this.status = status;}

	public  Integer getIfShow(){return ifShow;}

	public void setIfShow(Integer ifShow){this.ifShow = ifShow;}

	public String getReason(){return reason;}

	public void setReason(String reason){this.reason = reason;}

	public Integer getOrder_cost(){return order_cost;}

	public void setOrder_cost(Integer order_cost){this.order_cost = order_cost;}

}
