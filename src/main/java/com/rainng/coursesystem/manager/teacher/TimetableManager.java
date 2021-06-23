package com.rainng.coursesystem.manager.teacher;

import com.rainng.coursesystem.dao.ManagerDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.response.table.TimetableItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimetableManager extends BaseManager {
    private final ManagerDAO managerDAO;

    public TimetableManager(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public List<TimetableItemVO> listTeacherTimetable(Integer teacherId) {
        return managerDAO.listTeacherTimetable(teacherId);
    }
}
