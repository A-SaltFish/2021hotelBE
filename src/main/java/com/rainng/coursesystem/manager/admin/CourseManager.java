package com.rainng.coursesystem.manager.admin;

import com.rainng.coursesystem.dao.OrderDAO;
import com.rainng.coursesystem.dao.CustomerOrderDAO;
import com.rainng.coursesystem.dao.TeacherDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.bo.OrderItemBo;
import com.rainng.coursesystem.model.entity.OrderEntity;
import com.rainng.coursesystem.model.entity.TeacherEntity;
import com.rainng.coursesystem.model.vo.response.IdNameVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseManager extends BaseManager {
    private final TeacherDAO teacherDAO;
    private final OrderDAO orderDAO;
    private final CustomerOrderDAO customerOrderDAO;

    public CourseManager(TeacherDAO teacherDAO, OrderDAO orderDAO, CustomerOrderDAO customerOrderDAO) {
        this.teacherDAO = teacherDAO;
        this.orderDAO = orderDAO;
        this.customerOrderDAO = customerOrderDAO;
    }

    public Integer getPageCount(String departmentName, String teacherName, String name) {
        int count = orderDAO.count(departmentName, teacherName, name);
        return calcPageCount(count, OrderDAO.PAGE_SIZE);
    }

    public List<OrderItemBo> getPage(Integer index, String departmentName, String teacherName, String name) {
        return orderDAO.getPage(index, departmentName, teacherName, name);
    }

    public OrderEntity get(Integer id) {
        return orderDAO.get(id);
    }

    public int create(OrderEntity entity) {
        return orderDAO.insert(entity);
    }

    public int update(OrderEntity entity) {
        return orderDAO.update(entity);
    }

    public int delete(Integer id) {
        return orderDAO.delete(id);
    }

    public TeacherEntity getTeacherById(Integer teacherId) {
        return teacherDAO.get(teacherId);
    }

    public boolean hasStudentCourse(Integer courseId) {
        return customerOrderDAO.countByCourseId(courseId) > 0;
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<OrderEntity> entityList = orderDAO.listName();
        for (OrderEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
