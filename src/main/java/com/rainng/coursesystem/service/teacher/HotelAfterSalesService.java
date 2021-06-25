package com.rainng.coursesystem.service.teacher;

import com.rainng.coursesystem.manager.OptionManager;
import com.rainng.coursesystem.manager.teacher.HotelAfterSalesManager;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.vo.TeacherGradeVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class HotelAfterSalesService extends BaseService {
    private final HotelAfterSalesManager manager;
    private final OptionManager optionManager;

    public HotelAfterSalesService(HotelAfterSalesManager manager, OptionManager optionManager) {
        this.manager = manager;
        this.optionManager = optionManager;
    }

    public ResultVO getPageCount(Integer orderId,String hotelName) {
        Integer managerId = getUserId();
        return result(manager.getTeacherGradePageCount(managerId, orderId, hotelName));
    }

    public ResultVO getPage(Integer index, String courseName, String studentName) {
        Integer teacherId = getUserId();
        return result(manager.getTeacherGradePage(index, teacherId, courseName, studentName));
    }

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
    }
}
