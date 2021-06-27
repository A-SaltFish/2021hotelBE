package com.rainng.coursesystem.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.entity.ManagerOrderEntity;
import com.rainng.coursesystem.model.vo.response.CustomerInfoVo;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCustomerMapper extends BaseMapper<CustomerEntity> {

    //获取售后订单在该词缀下的页码数
    Integer countAdminCustomer(@Param("customerId") Integer customerId, @Param("customerName") String customerName);

    //获取售后订单页面
    IPage<CustomerInfoVo> getCustomerPage(IPage<CustomerInfoVo> page, @Param("customerId") Integer customerId,
                                          @Param("customerName") String customerName);

    //获取顾客的页码数
    IPage<HotelAllOrderItemVO> getPage(IPage<HotelAllOrderItemVO> page, @Param("managerId") Integer managerId);

    //删除用户
    int deleteCustomerById(@Param("customerId")Integer customerId);

    int changeStatusByOrderId(@Param("orderId") Integer orderId, @Param("orderStatus") Integer orderStatus);
}
