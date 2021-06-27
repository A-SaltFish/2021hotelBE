package com.rainng.coursesystem.model.entity;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Date;

public class Order {
    public Integer id = 0;
    public Integer customerId = 0;
    public Integer hotelId = 0;
    public Integer roomId = 0;
    public Date ctime ;
    public Integer status = 1;
    public Integer ifShow = 1;
    public String reason = "";


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

    public Date getCtime(){return ctime;}

    public void setCtime(Date ctime){this.ctime = ctime;}

    public Integer getStatus(){return  status;}

    public void setStatus(Integer status){this.status = status;}

    public  Integer getIfShow(){return ifShow;}

    public void setIfShow(Integer ifShow){this.ifShow = ifShow;}

    public String getReason(){return reason;}

    public void setReason(String reason){this.reason = reason;}

}
