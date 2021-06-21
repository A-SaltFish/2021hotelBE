package com.rainng.coursesystem.manager.student;

import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.response.table.StudentExamItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamManager extends BaseManager {
    private final CustomerOrderDAO customerOrderDAO;

    public ExamManager(CustomerOrderDAO customerOrderDAO) {
        this.customerOrderDAO = customerOrderDAO;
    }

    public List<StudentExamItemVO> listStudentExam(Integer studentId) {
        return customerOrderDAO.listStudentExam(studentId);
    }
}
