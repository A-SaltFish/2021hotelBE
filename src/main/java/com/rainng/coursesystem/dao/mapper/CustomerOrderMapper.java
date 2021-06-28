package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderMapper extends BaseMapper<CustomerOrderEntity> {

    Integer count(@Param("className")String className, @Param("courseName")String courseName, @Param("studentName")String studentName);

    Boolean deleteByOrderId(@Param("orderId")Integer orderId);

    Boolean cancelByOrderId(@Param("orderId")Integer orderId);

    Integer refundByOrderId(@Param("orderId")Integer orderId,@Param("reason") String reason);

    Integer remarkByOrderId(@Param("orderId")Integer orderId,@Param("comment") String comment,@Param("rank")Integer rank);

    IPage<CustomerOrderItemVO> getPage(IPage<CustomerOrderItemVO> page, @Param("customerId")Integer customerId);

    List<CustomerPreOrderVO> listCustomerPreOrder(@Param("customerId")Integer customerId);

}
