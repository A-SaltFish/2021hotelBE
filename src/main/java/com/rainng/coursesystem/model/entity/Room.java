package com.rainng.coursesystem.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Room implements Serializable {
    private Integer rm_hotel_id;
    private Integer room_id;
    private String room_type;
    private String room_describe;
    private String room_img;
    private Integer room_price;
    private Integer room_status;
    private Integer rm_order_id;
    private Integer rm_breakfast_type;
}
