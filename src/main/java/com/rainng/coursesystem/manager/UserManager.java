package com.rainng.coursesystem.manager;

import com.rainng.coursesystem.dao.AdminDAO;
import com.rainng.coursesystem.dao.CustomerDAO;
import com.rainng.coursesystem.dao.ManagerDAO;
import com.rainng.coursesystem.model.bo.AuthInfoBO;
import com.rainng.coursesystem.model.constant.UserType;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class UserManager extends BaseManager {
    private final AdminDAO adminDAO;
    private final ManagerDAO managerDAO;
    private final CustomerDAO customerDAO;

    public UserManager(AdminDAO adminDAO, ManagerDAO managerDAO, CustomerDAO customerDAO) {
        this.adminDAO = adminDAO;
        this.managerDAO = managerDAO;
        this.customerDAO = customerDAO;
    }

    public AuthInfoBO getAuthInfoByUsername(String userId, Integer userType) {
        if (userType == UserType.CUSTOMER) {
            return AuthInfoBO.fromStudent(customerDAO.getById(userId));
        } else if (userType == UserType.MANAGER) {
            return AuthInfoBO.fromTeacher(managerDAO.getById(userId));
        } else if (userType == UserType.ADMIN) {
            return AuthInfoBO.fromAdmin(adminDAO.getByUsername(userId));
        }

        return null;
    }

    public void updateStudentLastLoginTime(String number) {
        CustomerEntity entity = customerDAO.getById(number);
        if (entity == null) {
            return;
        }

        //entity.setLastLoginTime(new Date());
        customerDAO.update(entity);
    }
}
