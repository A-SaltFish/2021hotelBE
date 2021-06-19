package com.rainng.coursesystem.manager.admin;

import com.rainng.coursesystem.dao.ClassDAO;
import com.rainng.coursesystem.dao.StudentCourseDAO;
import com.rainng.coursesystem.dao.CustomerDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.ClassEntity;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.IdNameVO;
import com.rainng.coursesystem.model.vo.response.table.StudentItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentManager extends BaseManager {
    private final ClassDAO classDAO;
    private final StudentCourseDAO studentCourseDAO;
    private final CustomerDAO customerDAO;

    public StudentManager(ClassDAO classDAO, StudentCourseDAO studentCourseDAO, CustomerDAO customerDAO) {
        this.classDAO = classDAO;
        this.studentCourseDAO = studentCourseDAO;
        this.customerDAO = customerDAO;
    }

    public Integer getPageCount(String majorName, String className, String name) {
        int count = customerDAO.count(majorName, className, name);
        return calcPageCount(count, CustomerDAO.PAGE_SIZE);
    }

    public List<StudentItemVO> getPage(Integer index, String majorName, String className, String name) {
        return customerDAO.getPage(index, majorName, className, name);
    }

    public CustomerEntity get(Integer id) {
        return customerDAO.get(id);
    }

    public int create(CustomerEntity entity) {
        return customerDAO.insert(entity);
    }

    public int update(CustomerEntity entity) {
        return customerDAO.update(entity);
    }

    public int delete(Integer id) {
        return customerDAO.delete(id);
    }

    public ClassEntity getClassById(Integer classId) {
        return classDAO.get(classId);
    }

    public boolean hasStudentCourse(Integer studentId) {
        return studentCourseDAO.countByStudentId(studentId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<CustomerEntity> entityList = customerDAO.listName();
        for (CustomerEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
