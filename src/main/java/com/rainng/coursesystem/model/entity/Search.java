package com.rainng.coursesystem.model.entity;


public class Search {
    private Integer hotel_id;
    private String hotel_name;//酒店名称
    private String hotel_img;//酒店图
    private Float hotel_longitude;//酒店精度
    private Float hotel_latitude;//酒店纬度
    private Float hotel_rank;//星级
    private String hotel_city;//城市
    private Integer rm_breakfast_type;//早餐类型
    private Integer room_type;//房型



    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }


    public Float getHotel_rank() {
        return hotel_rank;
    }

    public void setHotel_rank(Float hotel_rank) {
        this.hotel_rank = hotel_rank;
    }

    public String getHotel_img() {
        return hotel_img;
    }

    public void setHotel_img(String hotel_img) {
        this.hotel_img = hotel_img;
    }

    public Float getHotel_longitude() {
        return hotel_longitude;
    }

    public void setHotel_longitude(Float hotel_longitude) {
        this.hotel_longitude = hotel_longitude;
    }

    public Float getHotel_latitude() {
        return hotel_latitude;
    }

    public void setHotel_latitude(Float hotel_latitude) {
        this.hotel_latitude = hotel_latitude;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public Integer getRoom_type() {
        return room_type;
    }

    public void setRoom_type(Integer room_type) {
        this.room_type = room_type;
    }

    public Integer getRm_breakfast_type() {
        return rm_breakfast_type;
    }

    public void setRm_breakfast_type(Integer rm_breakfast_type) {
        this.rm_breakfast_type = rm_breakfast_type;
    }

    public Search(String hotel_city, Integer rm_breakfast_type, Integer room_type, Float hotel_rank) {
        this.hotel_city = hotel_city;
        this.hotel_rank = hotel_rank;
        this.rm_breakfast_type = rm_breakfast_type;
        this.room_type = room_type;
    }

    public Search(){

    }

    @Override
    public String toString() {
        return "Search{" +
//                "hotel_id='" + hotel_id + '\'' +
                ", hotel_name='" + hotel_name + '\'' +
                ", hotel_img='" + hotel_img + '\'' +
                ", hotel_longitude=" + hotel_longitude +
                ", hotel_latitude=" + hotel_latitude +
                '}';
    }


}
