package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
@TableName("ht_order_form")
@Data
public class ManagerOrderEntity {
    public static final String ID = "order_id";
    public static final String HOTEL_ID = "od_hotel_id";
    public static final String ROOM_ID = "od_room_id";
    public static final String CUSTOMER_ID = "od_customer_id";
    public static final String CTIME = "order_ctime";
    public static final String STATUS = "order_status";
    public static final String IFSHOW = "order_ifshow";

    @NotNull
    @TableId(value = ID, type = IdType.AUTO)
    private Integer id;

    @NotNull(message = "必须选择顾客")
    @TableField(CUSTOMER_ID)
    private Integer customerId;

    @NotNull(message = "必须选择酒店ID")
    @TableField(HOTEL_ID)
    private Integer hotelId;

    @NotNull(message = "必须选择房间ID")
    @TableField(ROOM_ID)
    private Integer roomId;

    @NotNull(message = "必须创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(CTIME)
    private Integer ctime;

    @NotNull(message = "必须有状态")
    @TableField(STATUS)
    private Integer status;

    @NotNull(message = "必须选择是否可见")
    @TableField(IFSHOW)
    private Integer ifShow;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }
    public void setRoomId(Integer id) {
        this.roomId = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer id) {
        this.customerId = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }
    public void setHotelId(Integer id) {
        this.hotelId = id;
    }

}
