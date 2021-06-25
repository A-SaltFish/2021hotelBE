package com.rainng.coursesystem.manager.teacher;
import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.dao.redis.ManagerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelAfterSalesManager extends BaseManager {
    private final ManagerOrderDAO managerOrderDAO;

    //售后订单管理类
    public HotelAfterSalesManager(ManagerOrderDAO managerOrderDAO) {
        this.managerOrderDAO = managerOrderDAO;
    }

    //统计售后订单
    public Integer getAfterSalesCount(Integer managerId, Integer orderId, String roomName) {
        return calcPageCount(
                managerOrderDAO.countAfterSales(managerId, orderId, roomName),
                CustomerOrderDAO.PAGE_SIZE);
    }

    //获取售后订单页面
    public List<HotelAllOrderItemVO> getAfterSalesPage(Integer index, Integer managerId, Integer orderId, String roomName) {
        return managerOrderDAO.getAfterSalesPage(index, managerId, orderId, roomName);
    }
}
