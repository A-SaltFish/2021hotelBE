package com.rainng.coursesystem.manager.teacher;

import com.rainng.coursesystem.dao.OrderDAO;
import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.OrderEntity;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.TeacherGradeItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GradeManager extends BaseManager {
    private final OrderDAO orderDAO;
    private final CustomerOrderDAO customerOrderDAO;

    public GradeManager(OrderDAO orderDAO, CustomerOrderDAO customerOrderDAO) {
        this.orderDAO = orderDAO;
        this.customerOrderDAO = customerOrderDAO;
    }

    public Integer getTeacherGradePageCount(Integer teacherId, String courseName, String studentName) {
        return calcPageCount(
                customerOrderDAO.countTeacherGrade(teacherId, courseName, studentName),
                CustomerOrderDAO.PAGE_SIZE);
    }

    public List<TeacherGradeItemVO> getTeacherGradePage(Integer index, Integer teacherId, String courseName, String studentName) {
        return customerOrderDAO.getTeacherGradePage(index, teacherId, courseName, studentName);
    }

    public CustomerOrderEntity getStudentCourseById(Integer studentCourseId) {
        return customerOrderDAO.get(studentCourseId);
    }

    public OrderEntity getCourseById(Integer courseId) {
        return orderDAO.get(courseId);
    }


    public int updateStudentCourse(CustomerOrderEntity entity) {
        return customerOrderDAO.update(entity);
    }
}
