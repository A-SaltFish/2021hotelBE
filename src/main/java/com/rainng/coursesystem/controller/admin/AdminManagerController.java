package com.rainng.coursesystem.controller.admin;

import com.rainng.coursesystem.config.themis.annotation.Admin;
import com.rainng.coursesystem.model.entity.HotelEntity;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.admin.AdminManagerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/admin/manager")
@RestController
public class AdminManagerController {
    private final AdminManagerService service;

    public AdminManagerController(AdminManagerService service) {
        this.service = service;
    }

    //
    @RequestMapping("/page/count")
    public ResultVO getPageCount(Integer managerId,String managerName) {
        System.out.println("管理员 -顾客管理界面获取");
        return service.getPageCount(managerId, managerName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index,Integer managerId,String managerName) {
        System.out.println("管理员-顾客Page获取");
        return service.getPage(index, managerId, managerName);
    }

    @RequestMapping("/delete")
    public ResultVO deleteCustomer(Integer managerId){
        System.out.println("进行经理与酒店的删除");
        return service.deleteManagerAndHotel(managerId);
    }

    @RequestMapping("/pass")
    public ResultVO passManagerById(Integer managerId){
        System.out.println("进行经理注册审批");
        return service.passManagerById(managerId);
    }

    @PutMapping("/create/manager")
    public ResultVO adminInsertManager(@RequestBody @Validated ManagerEntity managerEntity) {
        System.out.println("进行经理新增服务");
        return service.adminInsertManager(managerEntity);
    }

    @PutMapping("/create/hotel")
    public ResultVO adminInsertHotel(@RequestBody @Validated HotelEntity hotelEntity) {
        System.out.println("进行酒店新增服务");
        return service.adminInsertHotel(hotelEntity);
    }

    ///@GetMapping("/{id}")
    //public ResultVO get(@PathVariable Integer id) {
     //   return service.get(id);
    //}

    //@PutMapping
    //public ResultVO update(@RequestBody @Validated TeacherGradeVO vo) {
    //    return service.update(vo);
    //}
}
