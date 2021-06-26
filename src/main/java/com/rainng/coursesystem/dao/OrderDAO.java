package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainng.coursesystem.dao.mapper.OrderMapper;
import com.rainng.coursesystem.model.bo.OrderItemBo;
import com.rainng.coursesystem.model.bo.StudentCourseSelectItemBO;
import com.rainng.coursesystem.model.entity.OrderEntity;
import com.rainng.coursesystem.model.vo.response.table.OrderItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final OrderMapper mapper;

    public OrderDAO(OrderMapper mapper) {
        this.mapper = mapper;
    }

    public int insert(OrderEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public OrderItemVO getExplicitOrderById(Integer id) {
        return mapper.getExplicitOrderById(id);
    }

        //通过ID获得实体
    public OrderEntity get(Integer id){return mapper.selectById(id);}

    public int update(OrderEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String departmentName, String teacherName, String name) {
        return mapper.count(departmentName, teacherName, name);
    }

    public List<OrderItemBo> getPage(Integer index, String departmentName, String teacherName, String name) {
        Page<OrderItemBo> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, departmentName, teacherName, name).getRecords();
    }


    public int increaseSelectedCount(Integer courseId) {
        OrderEntity course = mapper.selectById(courseId);
        course.setSelectedCount(course.getSelectedCount() + 1);

        return mapper.updateById(course);
    }

    public int decreaseSelectedCount(Integer courseId) {
        OrderEntity course = mapper.selectById(courseId);
        course.setSelectedCount(course.getSelectedCount() - 1);

        return mapper.updateById(course);
    }

    public Integer getDepartmentIdById(Integer courseId) {
        return mapper.getDepartmentIdById(courseId);
    }
}
