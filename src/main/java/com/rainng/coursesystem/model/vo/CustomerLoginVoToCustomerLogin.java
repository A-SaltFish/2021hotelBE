package com.rainng.coursesystem.model.vo;

import com.rainng.coursesystem.model.entity.CustomerLogin;

public class CustomerLoginVoToCustomerLogin {
    /**
     * 将表单中的对象转化为数据库中存储的用户对象（剔除表单中的code）
     * @param customerLoginVo
     * @return
     */
    public static CustomerLogin toUser(CustomerLoginVo customerLoginVo) {

        //创建一个数据库中存储的对象
        CustomerLogin customerLogin = new CustomerLogin();

        //传值
        customerLogin.setCustomer_name(customerLoginVo.getCustomer_name());
        customerLogin.setCustomer_tel(customerLoginVo.getCustomer_tel());
        customerLogin.setCustomer_password(customerLoginVo.getCustomer_password());
        customerLogin.setCustomer_email(customerLoginVo.getCustomer_email());

        // 返回包装后的对象
        return customerLogin;
    }
}
