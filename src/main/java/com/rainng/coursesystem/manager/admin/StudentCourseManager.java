package com.rainng.coursesystem.manager.admin;

import com.rainng.coursesystem.dao.CourseDAO;
import com.rainng.coursesystem.dao.StudentCourseDAO;
import com.rainng.coursesystem.dao.CustomerDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.CourseEntity;
import com.rainng.coursesystem.model.entity.StudentCourseEntity;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.table.StudentCourseItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StudentCourseManager extends BaseManager {
    private final CourseDAO courseDAO;
    private final StudentCourseDAO studentCourseDAO;
    private final CustomerDAO customerDAO;

    public StudentCourseManager(CourseDAO courseDAO, StudentCourseDAO studentCourseDAO, CustomerDAO customerDAO) {
        this.courseDAO = courseDAO;
        this.studentCourseDAO = studentCourseDAO;
        this.customerDAO = customerDAO;
    }

    public Integer getPageCount(String className, String courseName, String studentName) {
        int count = studentCourseDAO.count(className, courseName, studentName);
        return calcPageCount(count, StudentCourseDAO.PAGE_SIZE);
    }

    public List<StudentCourseItemVO> getPage(Integer index, String className, String courseName, String studentName) {
        return studentCourseDAO.getPage(index, className, courseName, studentName);
    }

    public StudentCourseEntity get(Integer id) {
        return studentCourseDAO.get(id);
    }

    @Transactional
    public int create(StudentCourseEntity entity) {
        courseDAO.increaseSelectedCount(entity.getCourseId());
        return studentCourseDAO.insert(entity);
    }

    public int update(StudentCourseEntity entity) {
        return studentCourseDAO.update(entity);
    }

    @Transactional
    public int delete(StudentCourseEntity entity) {
        courseDAO.decreaseSelectedCount(entity.getCourseId());
        return studentCourseDAO.delete(entity.getId());
    }

    public CourseEntity getCourseById(Integer courseId) {
        return courseDAO.get(courseId);
    }

    public CustomerEntity getStudentById(Integer studentId) {
        return customerDAO.get(studentId);
    }

    public StudentCourseEntity getByCourseIdAndStudentId(Integer courseId, Integer studentId) {
        return studentCourseDAO.getByCourseIdAndStudentId(courseId, studentId);
    }

    public Integer getStudentGradeById(Integer studentId) {
        return customerDAO.getGradeById(studentId);
    }

    public boolean inSameDepartment(Integer courseId, Integer studentId) {
        return courseDAO.getDepartmentIdById(courseId)
                .equals(customerDAO.getDepartmentIdById(studentId));
    }
}
