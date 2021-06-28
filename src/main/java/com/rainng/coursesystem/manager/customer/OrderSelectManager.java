package com.rainng.coursesystem.manager.customer;

import com.rainng.coursesystem.dao.OrderDAO;
import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.CustomerOrderItemVO;
import com.rainng.coursesystem.model.vo.response.table.OrderItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OrderSelectManager extends BaseManager {
    private final OrderDAO orderDAO;
    private final CustomerOrderDAO customerOrderDAO;

    public OrderSelectManager(OrderDAO orderDAO, CustomerOrderDAO customerOrderDAO) {
        this.orderDAO = orderDAO;
        this.customerOrderDAO = customerOrderDAO;
    }

    public Integer getPageCount(Integer customerId) {
        return calcPageCount(customerOrderDAO.countByCustomerId(customerId), CustomerOrderDAO.PAGE_SIZE);
    }

    public Boolean deleteOrder(Integer orderId){
        return customerOrderDAO.deleteOrder(orderId);
    }

    public List<CustomerOrderItemVO> getPage(Integer index, Integer customerId) {
        return customerOrderDAO.getPage(index,customerId);
    }

    public OrderItemVO getExplicitOrderById(Integer orderId) {
        return orderDAO.getExplicitOrderById(orderId);
    }


    @Transactional
    public int create(CustomerOrderEntity entity) {
        //该处从getCourseId变为getHotelId()
        return customerOrderDAO.insert(entity);
    }

}
