package com.rainng.coursesystem.manager.student;

import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("student_timetableManager")
public class TimetableManager extends BaseManager {
    private final CustomerOrderDAO customerOrderDAO;

    public TimetableManager(CustomerOrderDAO customerOrderDAO) {
        this.customerOrderDAO = customerOrderDAO;
    }

    public List<TimetableItemVO> listStudentTimetable(Integer studentId) {
        return customerOrderDAO.listStudentTimetable(studentId);
    }
}
