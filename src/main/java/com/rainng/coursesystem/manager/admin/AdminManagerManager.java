package com.rainng.coursesystem.manager.admin;
import com.rainng.coursesystem.dao.AdminManagerDAO;
import com.rainng.coursesystem.dao.AdminHotelDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.HotelEntity;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.ManagerInfoVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminManagerManager extends BaseManager {
    private final AdminManagerDAO adminManagerDAO;
    private final AdminHotelDAO adminHotelDAO;

    //售后订单管理类
    public AdminManagerManager(AdminManagerDAO managerOrderDAO,AdminHotelDAO hotelDAO) {
        this.adminManagerDAO = managerOrderDAO;
        this.adminHotelDAO=hotelDAO;
    }

    //统计售后订单
    public Integer countAdminCustomer(Integer managerId, String managerName) {
        return calcPageCount(
                adminManagerDAO.countAdminCustomer(managerId, managerName),
                adminManagerDAO.PAGE_SIZE);
    }

    public int deleteManagerAndHotel(Integer managerId ){
        if(adminManagerDAO.deleteManagerById(managerId)>0){
            System.out.println("经理删除完毕");
            return adminHotelDAO.deleteHotelByManagerId(managerId);
        }
        else return 0;
    }

    public int passManagerById(Integer managerId ){
        return adminManagerDAO.passManagerById(managerId);
    }

    public int adminInsertManager(ManagerEntity managerEntity){
        return adminManagerDAO.adminInsertManager(managerEntity);
    }

    public Integer getPreManagerId(){
        return adminManagerDAO.getPreManagerId();
    }

    public Integer getPreHotelId(){
        return adminHotelDAO.getPreHotelId();
    }

    public Integer setMgHotelId(Integer managerId,Integer hotelId){
        return adminManagerDAO.setHotelIdByManager(managerId,hotelId);
    }


    public int adminInsertHotel(HotelEntity hotelEntity){
        return adminHotelDAO.adminInsertHotel(hotelEntity);
    }

    //获取售后订单页面
    public List<ManagerInfoVo> getManagerPage(Integer index, Integer managerId, String managerName) {
        return adminManagerDAO.getManagerPage(index, managerId, managerName);
    }
}
