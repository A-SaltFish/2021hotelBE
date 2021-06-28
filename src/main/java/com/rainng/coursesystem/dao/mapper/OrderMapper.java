package com.rainng.coursesystem.dao.mapper;

import com.rainng.coursesystem.model.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper{
    @Insert("insert into ht_order_form(order_id,od_hotel_id,od_room_id,od_customer_id,order_status,order_ifshow,order_reason) values(#{id},#{hotelId},#{roomId},#{customerId},#{status},#{ifShow},#{reason})")
    int insertOrder(OrderEntity order);
}
