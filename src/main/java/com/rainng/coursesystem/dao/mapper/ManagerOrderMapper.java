package com.rainng.coursesystem.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.ManagerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import com.rainng.coursesystem.model.vo.response.table.HotelPreOrderItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerOrderMapper extends BaseMapper<ManagerOrderEntity> {

    //获取售后订单在该词缀下的页码数
    Integer countAfterSales(@Param("managerId")Integer managerId, @Param("orderId") Integer orderId, @Param("roomName") String roomName);

    //获取售后订单页面
    IPage<HotelAllOrderItemVO> getAfterSalesPage(IPage<HotelAllOrderItemVO> page, @Param("managerId")Integer managerId,
                                                 @Param("orderId")Integer orderId, @Param("roomName") String roomName);

    //获取历史订单的页码数
    IPage<HotelAllOrderItemVO> getPage(IPage<HotelAllOrderItemVO> page, @Param("managerId")Integer managerId);

    List<HotelPreOrderItemVO> HotelPreList(Integer managerId);
    //获取对应的历史订单
    Integer getHotelIdByManagerId(Integer managerId);

    int changeStatusByOrderId(@Param("orderId")Integer orderId,@Param("orderStatus")Integer orderStatus);
}
