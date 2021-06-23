package com.rainng.coursesystem.manager.teacher;

import com.rainng.coursesystem.dao.ManagerDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.response.table.HotelPreOrderItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("teacher_CourseManager")
public class HotelPreOrderManager extends BaseManager {
    private final ManagerDAO managerDAO;

    public HotelPreOrderManager(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public List<HotelPreOrderItemVO> HotelPreList(Integer managerId) {
        return managerDAO.HotelPreList(managerId);
    }
}
