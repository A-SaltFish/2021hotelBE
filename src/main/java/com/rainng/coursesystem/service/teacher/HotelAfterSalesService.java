package com.rainng.coursesystem.service.teacher;

import com.rainng.coursesystem.manager.teacher.HotelAfterSalesManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class HotelAfterSalesService extends BaseService {
    private final HotelAfterSalesManager manager;

    public HotelAfterSalesService(HotelAfterSalesManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(Integer orderId,String roomName) {
        Integer managerId = getUserId();
        return result(manager.getAfterSalesCount(managerId, orderId, roomName));
    }

    public ResultVO getPage(Integer index, Integer orderId, String roomName) {
        Integer managerId = getUserId();
        return result(manager.getAfterSalesPage(index, managerId, orderId, roomName));
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
