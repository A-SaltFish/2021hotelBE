package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainng.coursesystem.dao.mapper.CustomerOrderMapper;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final CustomerOrderMapper mapper;

    public CustomerOrderDAO(CustomerOrderMapper mapper) {
        this.mapper = mapper;
    }


    public int insert(CustomerOrderEntity entity) {
        return mapper.insert(entity);
    }

    public Boolean deleteOrder(Integer id) {
        return mapper.deleteByOrderId(id);
    }

    public int delete(Integer id){return mapper.deleteById(id);}

    public Boolean cancelOrderById(Integer id){
        return mapper.cancelByOrderId(id);
    }

    public CustomerOrderEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public Integer refund(Integer orderId,String reason) {
        return mapper.refundByOrderId(orderId,reason);
    }

    public Integer remark(Integer orderId,String comment,Integer rank) {
        return mapper.remarkByOrderId(orderId,comment,rank);
    }

    public int update(CustomerOrderEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String className, String courseName, String studentName) {
        return mapper.count(className, courseName, studentName);
    }

    public List<CustomerOrderItemVO> getPage(Integer index, Integer customerId) {
        Page<CustomerOrderItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page,customerId).getRecords();
    }


    public int countByCustomerId(Integer customerId) {
        LambdaQueryWrapper<CustomerOrderEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CustomerOrderEntity::getCustomerId, customerId);
        return mapper.selectCount(wrapper);
    }


    //????????????????????????preorder????????????????????????
    public List<CustomerPreOrderVO> listCustomerPreOrder(Integer customerId) {
        System.out.println(customerId);
        return mapper.listCustomerPreOrder(customerId);
    }

}
