package com.rainng.coursesystem.service.impl;

import com.rainng.coursesystem.dao.mapper.CustomerMapper;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired(required = false)
    private CustomerMapper customerMapper;

    @Override
    public int register(CustomerEntity customer){return customerMapper.insertcustomer(customer);}

    @Override
    public CustomerEntity login(String a,String b) {
        return customerMapper.login(a,b);
    }

    @Override
    public CustomerEntity findemail(String customer_email){
        return customerMapper.findemail(customer_email);
    }

    @Override
    public CustomerEntity findname(String customer_name){
        return customerMapper.findname(customer_name);
    }
}
