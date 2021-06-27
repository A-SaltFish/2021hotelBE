package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainng.coursesystem.dao.mapper.AdminManagerMapper;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.ManagerInfoVo;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminManagerDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final AdminManagerMapper mapper;

    public AdminManagerDAO(AdminManagerMapper mapper) {
        this.mapper = mapper;
    }

    public int adminInsertCustomer(CustomerEntity entity) {
        return mapper.insert(entity);
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


    public int deleteCustomerById(Integer customerId ) {
        return mapper.deleteCustomerById(customerId);
    }

    public int judge(Integer orderId){
        return mapper.changeStatusByOrderId(orderId,5);
    }

    public int getByHotelId(Integer hotelId) {
        LambdaQueryWrapper<CustomerEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(CustomerEntity::getId,hotelId);
        return mapper.selectCount(wrapper);
    }
}
