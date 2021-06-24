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
}
