package com.rainng.coursesystem.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TSearch implements Serializable {
    private Integer hotel_id;
    private String hotel_name;//酒店名称
    private String hotel_img;//酒店图
    private Float hotel_longitude;//酒店精度
    private Float hotel_latitude;//酒店纬度
    private Float hotel_rank;//星级
    private String hotel_city;//城市
    private Integer rm_breakfast_type;//早餐类型
    private Integer room_type;//房型
}
