package com.rainng.coursesystem.manager.customer;

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


    public Integer refund(Integer orderId,String reason) {
        System.out.println("orderId"+orderId+"\nreason:"+reason);
        return customerOrderDAO.refund(orderId,reason);
    }

    public Integer remark(Integer orderId,String comment,Integer rank) {
        System.out.println("orderId"+orderId+"\ncomment:"+comment+"\nrank"+rank);
        return customerOrderDAO.remark(orderId,comment,rank);
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
