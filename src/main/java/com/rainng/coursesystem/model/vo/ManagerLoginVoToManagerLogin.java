package com.rainng.coursesystem.model.vo;

import com.rainng.coursesystem.model.entity.ManagerLogin;

public class ManagerLoginVoToManagerLogin {

    public static ManagerLogin toManager(ManagerLoginVo managerLoginVo) {

        //创建一个数据库中存储的对象
        ManagerLogin managerLogin = new ManagerLogin();

        //传值
        managerLogin.setManager_name(managerLoginVo.getManager_name());
        managerLogin.setManager_tel(managerLoginVo.getManager_tel());
        managerLogin.setManager_password(managerLoginVo.getManager_password());
        managerLogin.setManager_email(managerLoginVo.getManager_email());

        // 返回包装后的对象
        return managerLogin;
    }
}
