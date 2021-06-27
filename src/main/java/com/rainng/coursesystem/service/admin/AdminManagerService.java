package com.rainng.coursesystem.service.admin;

import com.rainng.coursesystem.manager.admin.AdminManagerManager;
import com.rainng.coursesystem.model.entity.CustomerEntity;
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

    public ResultVO deleteCustomer(Integer managerId){
        System.out.println("进行用户删除操作："+managerId);
        if (manager.deleteCustomerById(managerId)>0)
            return result("删除用户成功！");
        else
            return result("删除失败！");
    }

    public ResultVO adminInsertCustomer(@RequestBody @Validated ManagerEntity managerEntity){
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

    /*
    public ResultVO update(TeacherGradeVO vo) {
        if (!optionManager.getAllowTeacherGrade()) {
            return failedResult("现在不是打分时间!");
        }

        Integer teacherId = getUserId();
        CustomerOrderEntity studentCourse = manager.getStudentCourseById(vo.getStudentCourseId());
        if (studentCourse == null) {
            return failedResult("学生选课Id:" + vo.getStudentCourseId() + "不存在");
        }
        //该处从getCourseId变为getHotelId()
        if (!manager.getCourseById(studentCourse.getHotelId()).getTeacherId().equals(teacherId)) {
            return failedResult("此课程非您教授");
        }

        BeanUtils.copyProperties(vo, studentCourse);

        manager.updateStudentCourse(studentCourse);
        return result("打分成功");
    }

    public ResultVO get(Integer studentCourseId) {
        if (!optionManager.getAllowTeacherGrade()) {
            return failedResult("现在不是打分时间!");
        }

        Integer teacherId = getUserId();
        CustomerOrderEntity studentCourse = manager.getStudentCourseById(studentCourseId);
        if (studentCourse == null) {
            return failedResult("学生选课Id:" + studentCourseId + "不存在");
        }
        //该处从getCourseId变为getHotelId()
        if (!manager.getCourseById(studentCourse.getHotelId()).getTeacherId().equals(teacherId)) {
            return failedResult("此课程非您教授");
        }

        TeacherGradeVO vo = new TeacherGradeVO();
        BeanUtils.copyProperties(studentCourse, vo);
        vo.setStudentCourseId(studentCourseId);

        return result(vo);
    }*/
}
