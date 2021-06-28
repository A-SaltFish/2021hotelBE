package com.rainng.coursesystem.service.admin;

import com.rainng.coursesystem.manager.admin.AdminCustomerManager;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdminCustomerService extends BaseService {
    private final AdminCustomerManager manager;

    public AdminCustomerService(AdminCustomerManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(Integer customerId,String customerName) {
        return result(manager.countAdminCustomer(customerId, customerName));
    }

    public ResultVO getPage(Integer index, Integer customerId, String customerName) {
        return result(manager.getCustomerPage(index,customerId, customerName));
    }

    public ResultVO deleteCustomer(Integer customerId){
        System.out.println("进行用户删除操作："+customerId);
        if (manager.deleteCustomerById(customerId)>0)
            return result("删除用户成功！");
        else
            return result("删除失败！");
    }

    public ResultVO adminInsertCustomer(@RequestBody @Validated CustomerEntity customerEntity){
        customerEntity.setDefaultBirthday();
        customerEntity.setDefaultLastLoginTime();
        System.out.println(customerEntity);
        if(manager.adminInsertCustomer(customerEntity)>0) {
            return result("后端添加成功！");
        }
        else return result("后端添加失败！");
    }

}
