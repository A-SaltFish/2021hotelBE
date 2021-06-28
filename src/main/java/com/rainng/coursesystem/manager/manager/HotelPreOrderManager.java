package com.rainng.coursesystem.manager.manager;

import com.rainng.coursesystem.dao.redis.ManagerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.response.table.HotelPreOrderItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("teacher_CourseManager")
public class HotelPreOrderManager extends BaseManager {
    private final ManagerOrderDAO managerOrderDAO;

    public HotelPreOrderManager(ManagerOrderDAO managerDAO) {
        this.managerOrderDAO = managerDAO;
    }

    public List<HotelPreOrderItemVO> HotelPreList(Integer managerId) {
        return managerOrderDAO.HotelPreList(managerId);
    }
}
