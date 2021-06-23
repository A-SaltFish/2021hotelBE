package com.rainng.coursesystem.manager.teacher;

import com.rainng.coursesystem.dao.redis.ManagerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.response.table.ManagerAllOrderItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimetableManager extends BaseManager {
    private final ManagerOrderDAO managerDAO;

    public TimetableManager(ManagerOrderDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public Integer getPageCount(Integer managerId) {
        Integer hotelId=managerDAO.getHotelIdByManagerId(managerId);
        //根据酒店ID对订单进行分类
        return calcPageCount(managerDAO.getByHotelId(hotelId), managerDAO.PAGE_SIZE);
    }

    public List<ManagerAllOrderItemVO> getPage(Integer index, Integer managerId) {
        return managerDAO.getPage(index,managerId);
    }
}
