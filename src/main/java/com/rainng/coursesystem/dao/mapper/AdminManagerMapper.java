package com.rainng.coursesystem.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.ManagerInfoVo;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminManagerMapper extends BaseMapper<CustomerEntity> {

    //获取售后订单在该词缀下的页码数
    Integer getManagerCount(@Param("managerId") Integer managerId, @Param("managerName") String managerName);

    //获取售后订单页面
    IPage<ManagerInfoVo> getManagerPage(IPage<ManagerInfoVo> page, @Param("managerId") Integer managerId,
                                         @Param("managerName") String managerName);

    //删除用户
    int deleteCustomerById(@Param("managerId") Integer managerId);

    int changeStatusByOrderId(@Param("orderId") Integer orderId, @Param("orderStatus") Integer orderStatus);
}
