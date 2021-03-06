package com.rainng.coursesystem.controller.admin;

import com.rainng.coursesystem.config.themis.annotation.Admin;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.admin.AdminCustomerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Admin
@RequestMapping("/admin/customer")
@RestController
public class AdminCustomerController {
    private final AdminCustomerService service;

    public AdminCustomerController(AdminCustomerService service) {
        this.service = service;
    }

    //
    @RequestMapping("/page/count")
    public ResultVO getPageCount(Integer customerId,String customerName) {
        System.out.println("管理员 -顾客管理界面获取");
        return service.getPageCount(customerId, customerName);
    }

    @RequestMapping("/page/{index}")
    public ResultVO getPage(@PathVariable Integer index,Integer customerId,String customerName) {
        System.out.println("管理员-顾客Page获取");
        return service.getPage(index, customerId, customerName);
    }

    @RequestMapping("/delete")
    public ResultVO deleteCustomer(Integer customerId){
        return service.deleteCustomer(customerId);
    }

    @PutMapping("/create")
    public ResultVO adminInsertCustomer(@RequestBody @Validated CustomerEntity customerEntity) {
        System.out.println("进行顾客新增服务");
        return service.adminInsertCustomer(customerEntity);
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
