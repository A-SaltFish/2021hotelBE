package com.rainng.coursesystem.model.entity;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class TSearch implements Serializable {
    private Integer hotel_id;
    private String hotel_name;//酒店名称
    private String ht_city_name;//城市名称
    private Float hotel_rank;//星级
    private Integer hotel_isopen;
    private Integer hotel_room_num;
    private Integer hotel_min_price;
    private Float hotel_longitude;
    private Float hotel_latitude;
    private String room_img1;
    private String room_img2;
    private String hotel_img;
}
