package com.rainng.coursesystem.service;

import com.rainng.coursesystem.model.entity.CustomerEntity;

public interface CustomerService {
    int register(CustomerEntity customer);
    CustomerEntity login(String a,String b);
    CustomerEntity findemail(String email);
    CustomerEntity findname(String name);
}
