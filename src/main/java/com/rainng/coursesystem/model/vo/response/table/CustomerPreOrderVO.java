package com.rainng.coursesystem.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerPreOrderVO {
	private Integer orderId;
	private String hotelName;
	private String roomName;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date cTime;
	private Integer orderCost;
	private String payment;
	private String status;
	private Integer customerId;
	private String hotelTel;

	public Integer getId() {
		return orderId;
	}
	public void setId(Integer oid) {
		this.orderId = oid;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer id) {
		this.customerId = id;
	}
	public String gethotelName() {
		return hotelName;
	}
	public void sethotelName(String name) {
		this.hotelName = name;
	}
	public String getroomName() {
		return roomName;
	}
	public void setroomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(Integer cost) {
		this.orderCost = cost;
	}
	public Date getTime() {
		return cTime;
	}
	public void setTime(Date ctime) {
		this.cTime = ctime;
	}
	public String getPayment(){return payment;}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getStatus(){return status;}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
