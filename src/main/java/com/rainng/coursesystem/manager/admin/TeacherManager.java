package com.rainng.coursesystem.manager.admin;

import com.rainng.coursesystem.dao.OrderDAO;
import com.rainng.coursesystem.dao.DepartmentDAO;
import com.rainng.coursesystem.dao.ManagerDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.DepartmentEntity;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.IdNameVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherItemVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherManager extends BaseManager {
    private final DepartmentDAO departmentDAO;
    private final ManagerDAO managerDAO;
    private final OrderDAO orderDAO;

    public TeacherManager(DepartmentDAO departmentDAO, ManagerDAO managerDAO, OrderDAO orderDAO) {
        this.departmentDAO = departmentDAO;
        this.managerDAO = managerDAO;
        this.orderDAO = orderDAO;
    }

    public Integer getPageCount(String departmentName, String name) {
        int count = managerDAO.count(departmentName, name);
        return calcPageCount(count, ManagerDAO.PAGE_SIZE);
    }


    public List<TeacherItemVO> getPage(Integer index, String departmentName, String name) {
        return managerDAO.getPage(index, departmentName, name);
    }

    public ManagerEntity get(Integer id) {
        return managerDAO.get(id);
    }

    public int create(ManagerEntity entity) {
        return managerDAO.insert(entity);
    }

    public int update(ManagerEntity entity) {
        return managerDAO.update(entity);
    }

    public int delete(Integer id) {
        return managerDAO.delete(id);
    }

    public boolean hasCourse(Integer teacherId) {
        return orderDAO.countByTeacherId(teacherId) > 0;
    }

    public DepartmentEntity getDepartmentById(Integer id) {
        return departmentDAO.get(id);
    }

    public List<IdNameVO> listName() {
        List<IdNameVO> voList = new ArrayList<>();
        List<ManagerEntity> entityList = managerDAO.listName();
        for (ManagerEntity entity : entityList) {
            voList.add(new IdNameVO(entity.getId(), entity.getName()));
        }

        return voList;
    }
}
