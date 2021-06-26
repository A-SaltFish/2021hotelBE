package com.rainng.coursesystem.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ManagerLogin implements Serializable {
    public Integer manager_id;
    public String manager_name;
    public Integer mg_hotel_id;
    public String manager_describe;
    public String manager_tel;
    public String manager_password;
    public Integer manager_ifpass;
    public String manager_email;
    public Integer manager_avaliable;

    public  Integer getManager_id(){return manager_id;}
    public  String getManager_name(){return manager_name;}
    public Integer getMg_hotel_id(){return mg_hotel_id;}
    public  String getManager_describe(){return manager_describe;}
    public  String getManager_password(){return manager_password;}
    public Integer getManager_ifpass(){return manager_ifpass; }
    public String getManager_email(){return manager_email;}
    public Integer getManager_avaliable(){return manager_avaliable;}

    public void setManager_id(Integer manager_id){this.manager_id = manager_id;}
    public void setManager_name(String manager_name){this.manager_name = manager_name;}
    public void setMg_hotel_id(Integer mg_hotel_id){this.mg_hotel_id = mg_hotel_id;}
    public void setManager_describe(String manager_describe){this.manager_describe = manager_describe;}
    public void setManager_password(String manager_password){this.manager_password = manager_password;}
    public void setManager_ifpass(Integer manager_ifpass){this.manager_ifpass = manager_ifpass;}
    public void setManager_email(String manager_email){this.manager_ifpass = manager_ifpass;}
    public void setManager_avaliable(Integer manager_avaliable){this.manager_avaliable = manager_avaliable;}
}
