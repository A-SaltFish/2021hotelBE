package com.rainng.coursesystem.manager.admin;
import com.rainng.coursesystem.dao.AdminManagerDAO;
import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.ManagerInfoVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminManagerManager extends BaseManager {
    private final AdminManagerDAO adminManagerDAO;

    //售后订单管理类
    public AdminManagerManager(AdminManagerDAO managerOrderDAO) {
        this.adminManagerDAO = managerOrderDAO;
    }

    //统计售后订单
    public Integer countAdminCustomer(Integer managerId, String managerName) {
        return calcPageCount(
                adminManagerDAO.countAdminCustomer(managerId, managerName),
                CustomerOrderDAO.PAGE_SIZE);
    }

    public int deleteCustomerById(Integer managerId ){
        return adminManagerDAO.deleteCustomerById(managerId);
    }

    public int adminInsertCustomer(CustomerEntity customerEntity){
        return adminManagerDAO.adminInsertCustomer(customerEntity);
    }

    //获取售后订单页面
    public List<ManagerInfoVo> getManagerPage(Integer index, Integer managerId, String managerName) {
        return adminManagerDAO.getManagerPage(index, managerId, managerName);
    }
}
