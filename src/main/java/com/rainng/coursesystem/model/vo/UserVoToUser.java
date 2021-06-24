package com.rainng.coursesystem.model.vo;

import com.rainng.coursesystem.model.entity.User;

public class UserVoToUser {
    /**
     * 将表单中的对象转化为数据库中存储的用户对象（剔除表单中的code）
     * @param userVo
     * @return
     */
    public static User toUser(UserVo userVo) {

        //创建一个数据库中存储的对象
        User user = new User();

        //传值
        user.setCustomer_name(userVo.getCustomer_name());
//        user.setCustomer_tel(userVo.getCustomer_tel());
        user.setCustomer_password(userVo.getCustomer_password());
        user.setCustomer_email(userVo.getCustomer_email());

        // 返回包装后的对象
        return user;
    }
}
