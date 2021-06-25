package com.rainng.coursesystem.manager.student;

import com.rainng.coursesystem.dao.OrderDAO;
import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.dao.CustomerDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.table.CustomerOrderItemVO;
import com.rainng.coursesystem.model.vo.response.table.OrderItemVO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OrderSelectManager extends BaseManager {
    private final OrderDAO orderDAO;
    private final CustomerDAO customerDAO;
    private final CustomerOrderDAO customerOrderDAO;

    public OrderSelectManager(OrderDAO orderDAO, CustomerDAO customerDAO, CustomerOrderDAO customerOrderDAO) {
        this.orderDAO = orderDAO;
        this.customerDAO = customerDAO;
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

    public CustomerEntity getStudentById(Integer studentId) {
        return customerDAO.get(studentId);
    }

    public boolean inSameDepartment(Integer courseId, Integer studentId) {
        return orderDAO.getDepartmentIdById(courseId)
                .equals(customerDAO.getDepartmentIdById(studentId));
    }

    public CustomerOrderEntity getStudentCourseByCourseIdAndStudentId(Integer courseId, Integer studentId) {
        return customerOrderDAO.getByCourseIdAndStudentId(courseId, studentId);
    }

    public Integer getStudentGradeById(Integer studentId) {
        return customerDAO.getGradeById(studentId);
    }


    @Transactional
    public int create(CustomerOrderEntity entity) {
        //该处从getCourseId变为getHotelId()
        orderDAO.increaseSelectedCount(entity.getHotelId());
        return customerOrderDAO.insert(entity);
    }

    public int countStudentCourseSelectedByTimePart(Integer studentId, String timePart) {
        return customerOrderDAO.countStudentCourseSelectedByTimePart(studentId, timePart);
    }
}
