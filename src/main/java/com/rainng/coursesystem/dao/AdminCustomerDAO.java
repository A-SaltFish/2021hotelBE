package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainng.coursesystem.dao.mapper.AdminCustomerMapper;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.CustomerInfoVo;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminCustomerDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final AdminCustomerMapper mapper;

    public AdminCustomerDAO(AdminCustomerMapper mapper) {
        this.mapper = mapper;
    }

    public int adminInsertCustomer(CustomerEntity entity) {
        return mapper.insert(entity);
    }

    public List<HotelAllOrderItemVO> getPage(Integer index, Integer managerId) {
        Page<HotelAllOrderItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, managerId).getRecords();
    }


    //统计售后订单
    public Integer countAdminCustomer(Integer customerId, String customerName) {
        System.out.println("customerId:"+customerId);
        System.out.println("customerName:"+customerName);
        return mapper.countAdminCustomer(customerId, customerName);
    }

    //获取售后订单
    public List<CustomerInfoVo> getCustomerPage(Integer index, Integer customerId, String customerName) {
        Page<CustomerInfoVo> page = new Page<>(index, PAGE_SIZE);
        return mapper.getCustomerPage(page, customerId, customerName).getRecords();
    }


    public int deleteCustomerById(Integer customerId ) {
        return mapper.deleteCustomerById(customerId);
    }

}
