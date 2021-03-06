package com.rainng.coursesystem.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class HotelPreOrderItemVO {
	private Integer orderId;
	private Integer customerId;
	private String roomId;
	private String customerTel;
	private String roomType;
	private Integer precost;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createTime;
	//private String payment;
	private Integer status;
	//private String comment;
	//private Integer rank;

	public Integer getId() {
		return orderId;
	}
	public void setId(Integer id) {
		this.orderId = id;
	}
	public Integer getPrecost() {
		return precost;
	}
	public void setPrecost(Integer cost) {
		this.precost = cost;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
}
