package com.rainng.coursesystem.manager.manager;

import com.rainng.coursesystem.dao.redis.ManagerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelAllOrderManager extends BaseManager {
    private final ManagerOrderDAO managerOrderDAO;

    public HotelAllOrderManager(ManagerOrderDAO managerDAO) {
        this.managerOrderDAO = managerDAO;
    }

    public Integer getPageCount(Integer managerId) {
        Integer hotelId= managerOrderDAO.getHotelIdByManagerId(managerId);
        //根据酒店ID对订单进行分类
        return calcPageCount(managerOrderDAO.getByHotelId(hotelId), managerOrderDAO.PAGE_SIZE);
    }

    public List<HotelAllOrderItemVO> getPage(Integer index, Integer managerId) {
        return managerOrderDAO.getPage(index,managerId);
    }
}
