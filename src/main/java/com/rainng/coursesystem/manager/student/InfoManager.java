package com.rainng.coursesystem.manager.student;

import com.rainng.coursesystem.dao.CustomerDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.CustomerInfoVo;
import org.springframework.stereotype.Component;

@Component
public class InfoManager extends BaseManager {
    private final CustomerDAO customerDAO;

    public InfoManager(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CustomerInfoVo getCustomerInfoById(Integer studentId) {
        return customerDAO.getCustomerInfoById(studentId);
    }

    public CustomerEntity getCustomerById(Integer customerId) {
        return customerDAO.get(customerId);
    }

    public int updateCustomer(CustomerEntity entity) {
        return customerDAO.update(entity);
    }
}
