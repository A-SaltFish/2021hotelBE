package com.rainng.coursesystem.manager.admin;
import com.rainng.coursesystem.dao.AdminCustomerDAO;
import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.CustomerInfoVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminCustomerManager extends BaseManager {
    private final AdminCustomerDAO adminCustomerDAO;

    //售后订单管理类
    public AdminCustomerManager(AdminCustomerDAO managerOrderDAO) {
        this.adminCustomerDAO = managerOrderDAO;
    }

    //统计售后订单
    public Integer countAdminCustomer(Integer customerId, String customerName) {
        return calcPageCount(
                adminCustomerDAO.countAdminCustomer(customerId, customerName),
                CustomerOrderDAO.PAGE_SIZE);
    }

    public int deleteCustomerById(Integer customerId ){
        return adminCustomerDAO.deleteCustomerById(customerId);
    }

    public int adminInsertCustomer(CustomerEntity customerEntity){
        return adminCustomerDAO.adminInsertCustomer(customerEntity);
    }

    //获取售后订单页面
    public List<CustomerInfoVo> getCustomerPage(Integer index, Integer customerId, String customerName) {
        return adminCustomerDAO.getCustomerPage(index, customerId, customerName);
    }
}
