package com.rainng.coursesystem.service.student;

import com.rainng.coursesystem.manager.student.InfoManager;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.request.CustomerInfoFormVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class InfoService extends BaseService {
    private final UserService userService;

    private final InfoManager manager;

    public InfoService(UserService userService, InfoManager manager) {
        this.userService = userService;
        this.manager = manager;
    }

    public ResultVO get() {
        return result(manager.getCustomerInfoById(getUserId()));
    }

    public ResultVO update(@RequestBody @Validated CustomerInfoFormVO studentInfoForm) {
        CustomerEntity customer = manager.getCustomerById(getUserId());

        //String password = studentInfoForm.getPassword();
      //  if (password == null || password.equals("")) {
            String password = customer.getPassword();
     //   } else {
     //       password = userService.computePasswordHash(password);
     //   }

        BeanUtils.copyProperties(studentInfoForm, customer);
        customer.setPassword(password);
        manager.updateCustomer(customer);

        return result("更新成功");
    }
}
