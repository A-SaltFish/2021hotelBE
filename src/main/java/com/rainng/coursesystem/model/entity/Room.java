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
    private String room_status;
    private String rm_order_id;
    private String rm_breakfast_type;
}
