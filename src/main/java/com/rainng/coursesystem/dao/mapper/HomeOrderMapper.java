package com.rainng.coursesystem.dao.mapper;

import com.rainng.coursesystem.model.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeOrderMapper{
    @Insert("insert into ht_order_form(order_cost,order_ctime,od_hotel_id,od_room_id,od_customer_id,order_status,order_ifshow) values(#{order_cost},now(),#{hotelId},#{roomId},#{customerId},#{status},#{ifShow})")
    int insertOrder(OrderEntity order);

}
