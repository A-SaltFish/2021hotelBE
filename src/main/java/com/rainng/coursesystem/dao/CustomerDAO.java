package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainng.coursesystem.dao.mapper.CustomerMapper;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.CustomerInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final CustomerMapper mapper;

    public CustomerDAO(CustomerMapper mapper) {
        this.mapper = mapper;
    }

    public CustomerEntity getById(String id) {
        QueryWrapper<CustomerEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id", id);
        if(mapper.selectOne(wrapper)==null){
            QueryWrapper<CustomerEntity> wrapper1 = new QueryWrapper<>();
            System.out.println("当前用户ID不匹配"+id);
            wrapper1.eq("customer_email", id);
            return mapper.selectOne(wrapper1);
        }
        return mapper.selectOne(wrapper);
    }


    public int insert(CustomerEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public CustomerEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(CustomerEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String majorName, String className, String name) {
        return mapper.count(majorName, className, name);
    }




    public List<CustomerEntity> listName() {
        LambdaQueryWrapper<CustomerEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(CustomerEntity::getId, CustomerEntity::getName);

        return mapper.selectList(wrapper);
    }


    public CustomerInfoVo getCustomerInfoById(Integer studentId) {
        return mapper.getCustomerInfoById(studentId);
    }
}
