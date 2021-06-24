package com.rainng.coursesystem.manager.admin;

import com.rainng.coursesystem.dao.OrderDAO;
import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.dao.CustomerDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.OrderEntity;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.table.CustomerOrderItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CustomerOrderManager extends BaseManager {
    private final OrderDAO orderDAO;
    private final CustomerOrderDAO customerOrderDAO;
    private final CustomerDAO customerDAO;

    public CustomerOrderManager(OrderDAO orderDAO, CustomerOrderDAO customerOrderDAO, CustomerDAO customerDAO) {
        this.orderDAO = orderDAO;
        this.customerOrderDAO = customerOrderDAO;
        this.customerDAO = customerDAO;
    }

    public Integer getPageCount(String className, String courseName, String studentName) {
        int count = customerOrderDAO.count(className, courseName, studentName);
        return calcPageCount(count, CustomerOrderDAO.PAGE_SIZE);
    }

    public List<CustomerOrderItemVO> getPage(Integer index,Integer customerId) {
        return customerOrderDAO.getPage(index,customerId);
    }

    public CustomerOrderEntity get(Integer id) {
        return customerOrderDAO.get(id);
    }

    @Transactional
    public int create(CustomerOrderEntity entity) {
        //orderDAO.increaseSelectedCount(entity.getCourseId());
        return customerOrderDAO.insert(entity);
    }

    public int update(CustomerOrderEntity entity) {
        return customerOrderDAO.update(entity);
    }

    @Transactional
    public int delete(CustomerOrderEntity entity) {
        //orderDAO.decreaseSelectedCount(entity.getCourseId());
        return customerOrderDAO.delete(entity.getId());
    }

    public OrderEntity getCourseById(Integer courseId) {
        return orderDAO.get(courseId);
    }

    public CustomerEntity getStudentById(Integer studentId) {
        return customerDAO.get(studentId);
    }

    public CustomerOrderEntity getByCourseIdAndStudentId(Integer courseId, Integer studentId) {
        return customerOrderDAO.getByCourseIdAndStudentId(courseId, studentId);
    }

    public Integer getStudentGradeById(Integer studentId) {
        return customerDAO.getGradeById(studentId);
    }

    public boolean inSameDepartment(Integer courseId, Integer studentId) {
        return orderDAO.getDepartmentIdById(courseId)
                .equals(customerDAO.getDepartmentIdById(studentId));
    }
}
