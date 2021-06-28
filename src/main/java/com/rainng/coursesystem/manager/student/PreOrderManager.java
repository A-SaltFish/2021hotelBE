package com.rainng.coursesystem.manager.student;

import com.rainng.coursesystem.dao.OrderDAO;
import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.CustomerPreOrderVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("student_CourseManager")
public class PreOrderManager extends BaseManager {
    private final CustomerOrderDAO customerOrderDAO;
    private final OrderDAO orderDAO;

    public PreOrderManager(CustomerOrderDAO customerOrderDAO, OrderDAO orderDAO) {
        this.customerOrderDAO = customerOrderDAO;
        this.orderDAO = orderDAO;
    }

    public CustomerOrderEntity getStudentCourseById(Integer studentCourseId) {
        return customerOrderDAO.get(studentCourseId);
    }


    @Transactional
    public Boolean cancelOrder(Integer orderId) {
        return customerOrderDAO.cancelOrderById(orderId);
    }

    public List<CustomerPreOrderVO> listCustomerPreOrder(Integer customerId) {
        List<CustomerPreOrderVO> a=customerOrderDAO.listCustomerPreOrder(customerId);
        System.out.println(a);
        return a;
    }
}
