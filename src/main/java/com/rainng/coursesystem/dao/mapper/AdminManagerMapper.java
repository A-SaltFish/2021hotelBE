package com.rainng.coursesystem.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.ManagerInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminManagerMapper extends BaseMapper<ManagerEntity> {

    //获取售后订单在该词缀下的页码数
    Integer getManagerCount(@Param("managerId") Integer managerId, @Param("managerName") String managerName);

    Integer setHotelIdByManager(@Param("managerId") Integer managerId, @Param("hotelId") Integer hotelId);

    Integer getPreManagerId();

    //获取售后订单页面
    IPage<ManagerInfoVo> getManagerPage(IPage<ManagerInfoVo> page, @Param("managerId") Integer managerId,
                                         @Param("managerName") String managerName);

    //删除用户
    int deleteManagerById(@Param("managerId") Integer managerId);

    int passManagerById(@Param("managerId") Integer managerId);

    int changeStatusByOrderId(@Param("orderId") Integer orderId, @Param("orderStatus") Integer orderStatus);
}
