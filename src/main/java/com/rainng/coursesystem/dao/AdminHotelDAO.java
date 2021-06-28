package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainng.coursesystem.dao.mapper.AdminHotelMapper;
import com.rainng.coursesystem.model.entity.HotelEntity;
import com.rainng.coursesystem.model.vo.response.ManagerInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminHotelDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final AdminHotelMapper mapper;

    public AdminHotelDAO(AdminHotelMapper mapper) {
        this.mapper = mapper;
    }

    public int adminInsertHotel(HotelEntity entity) {
        return mapper.insert(entity);
    }

    public Integer getPreHotelId(){
        return mapper.getPreHotelId();
    }

    //统计售后订单
    public Integer countAdminCustomer(Integer managerId, String managerName) {
        System.out.println("managerId:"+managerId);
        System.out.println("managerName:"+managerName);
        return mapper.getManagerCount(managerId, managerName);
    }

    //获取售后订单
    public List<ManagerInfoVo> getManagerPage(Integer index, Integer managerId, String managerName) {
        Page<ManagerInfoVo> page = new Page<>(index, PAGE_SIZE);
  //      System.out.println("orderId2:"+orderId);
  //      System.out.println("roomName2:"+roomName);
        return mapper.getManagerPage(page, managerId, managerName).getRecords();
    }


    public int deleteHotelByManagerId(Integer managerId ) {
        return mapper.deleteHotelByManagerId(managerId);
    }

}
