package com.rainng.coursesystem.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.HotelEntity;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.ManagerInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminHotelMapper extends BaseMapper<HotelEntity> {

    //获取售后订单在该词缀下的页码数
    Integer getManagerCount(@Param("managerId") Integer managerId, @Param("managerName") String managerName);

    //获取售后订单页面
    IPage<ManagerInfoVo> getManagerPage(IPage<ManagerInfoVo> page, @Param("managerId") Integer managerId,
                                        @Param("managerName") String managerName);

    Integer getPreHotelId();

    //删除用户
    int deleteHotelByManagerId(@Param("managerId") Integer managerId);

    int changeStatusByOrderId(@Param("orderId") Integer orderId, @Param("orderStatus") Integer orderStatus);
}
