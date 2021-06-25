package com.rainng.coursesystem.model.vo.response.table;

import lombok.Data;

@Data
public class HotelRoomVO {
    private Integer hotelId;
    private Integer roomId;
    private String roomType;
    private String description;
    private String img;
    private Integer status;
    private Integer breakfast;
    private Integer price;
    
}
