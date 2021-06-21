package com.rainng.coursesystem.model.vo.response.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerOrderItemVO {
    private Integer orderId;
    private String hotelName;
    private Integer cost;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createTime;
	private String payment;
    private Integer status;

	public Integer getId() {
		return orderId;
	}
	public void setId(Integer id) {
		this.orderId = id;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}
