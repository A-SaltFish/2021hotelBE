package com.rainng.coursesystem.service.admin;

import com.rainng.coursesystem.manager.admin.AdminManagerManager;
import com.rainng.coursesystem.model.entity.HotelEntity;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdminManagerService extends BaseService {
    private final AdminManagerManager manager;

    public AdminManagerService(AdminManagerManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(Integer managerId,String managerName) {
        return result(manager.countAdminCustomer(managerId, managerName));
    }

    public ResultVO getPage(Integer index, Integer managerId, String managerName) {
        return result(manager.getManagerPage(index,managerId, managerName));
    }

    public ResultVO deleteManagerAndHotel(Integer managerId){
        System.out.println("进行经理删除："+managerId);
        if (manager.deleteManagerAndHotel(managerId)>0)
            return result("删除经理成功！");
        else
            return result("删除失败！");
    }

    public ResultVO passManagerById(Integer managerId){
        System.out.println("审批ID："+managerId);
        if (manager.passManagerById(managerId)>0)
            return result("审批成功！");
        else
            return result("审批失败！");
    }

    public ResultVO adminInsertManager(@RequestBody @Validated ManagerEntity managerEntity){
        System.out.println(managerEntity);
        if(manager.adminInsertManager(managerEntity)>0) {
                 return result("后端经理 添加成功");
        }
        else return result("后端经理 添加失败");
    }

    public ResultVO adminInsertHotel(@RequestBody @Validated HotelEntity hotelEntity){
        Integer managerId=manager.getPreManagerId();
        hotelEntity.setManagerId(managerId);
        System.out.println(hotelEntity);
        if(manager.adminInsertHotel(hotelEntity)>0) {
            manager.setMgHotelId(managerId,manager.getPreHotelId());
            return result("后端酒店 添加成功 并更新数据");
        }
        else return result("后端酒店 添加失败");
    }

}
