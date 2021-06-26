package com.rainng.coursesystem.model.vo;


import lombok.Data;

@Data
public class ManagerLoginVo {
    private String manager_name;

    private String manager_password;

    private String manager_email;

    private String manager_tel;

    private String code;

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_email() { return manager_email; }

    public void setManager_email(String manager_email) { this.manager_email = manager_email; }

    public String getCusotmer_tel() {return manager_tel;}

    public void setManager_tel(String manager_tel) { this.manager_tel = manager_tel; }
}
