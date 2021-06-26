package com.rainng.coursesystem.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@TableName("ht_order_form")
@Data
public class CustomerOrderEntity implements Serializable {
    public Integer id;
    public Integer customerId;
    public Integer hotelId;
    public Integer roomId;
    public Integer ctime;
    public Integer status;
    public Integer ifShow;
    public String reason;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id){this.id = id;}

    public Integer getCustomerId(){return customerId;}

    public void setCustomerId(Integer customerId){this.customerId =customerId;}

    public Integer getHotelId(){return hotelId;}

    public void setHotelId(Integer hotelId){this.hotelId = hotelId;}

    public Integer getRoomId() {return roomId;}

    public void setRoomId(Integer roomId) {this.roomId = hotelId;}

    public Integer getCtime(){return ctime;}

    public void setCtime(Integer ctime){this.ctime = ctime;}

    public Integer getStatus(){return  status;}

    public void setStatus(Integer status){this.status = status;}

    public  Integer getIfShow(){return ifShow;}

    public void setIfShow(Integer ifShow){this.ifShow = ifShow;}

    public String getReason(){return reason;}

    public void setReason(String reason){this.reason = reason;}







}
