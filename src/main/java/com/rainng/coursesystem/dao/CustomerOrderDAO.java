package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainng.coursesystem.dao.mapper.CustomerOrderMapper;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerOrderDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final CustomerOrderMapper mapper;

    public CustomerOrderDAO(CustomerOrderMapper mapper) {
        this.mapper = mapper;
    }


    public int insert(CustomerOrderEntity entity) {
        return mapper.insert(entity);
    }

    public Boolean deleteOrder(Integer id) {
        return mapper.deleteByOrderId(id);
    }

    public int delete(Integer id){return mapper.deleteById(id);}

    public Boolean cancelOrderById(Integer id){
        return mapper.cancelByOrderId(id);
    }

    public CustomerOrderEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(CustomerOrderEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String className, String courseName, String studentName) {
        return mapper.count(className, courseName, studentName);
    }

    public List<CustomerOrderItemVO> getPage(Integer index, Integer customerId) {
        Page<CustomerOrderItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page,customerId).getRecords();
    }

    public int countByCourseId(Integer customerId) {
        LambdaQueryWrapper<CustomerOrderEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CustomerOrderEntity::getId, customerId);

        return mapper.selectCount(wrapper);
    }

    public int countByCustomerId(Integer customerId) {
        LambdaQueryWrapper<CustomerOrderEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CustomerOrderEntity::getCustomerId, customerId);
        return mapper.selectCount(wrapper);
    }

    public CustomerOrderEntity getByCourseIdAndStudentId(Integer courseId, Integer studentId) {
        LambdaQueryWrapper<CustomerOrderEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(CustomerOrderEntity::getId)
                .eq(CustomerOrderEntity::getHotelId, courseId)
                .eq(CustomerOrderEntity::getId, studentId);

        return mapper.selectOne(wrapper);
    }

    //对应前端顾客端的preorder页面，用于初始化
    public List<CustomerPreOrderVO> listCustomerPreOrder(Integer customerId) {
        return mapper.listCustomerPreOrder(customerId);
    }

    public List<StudentExamItemVO> listStudentExam(Integer studentId) {
        return mapper.listStudentExam(studentId);
    }

    public Integer countStudentCourseSelectedByTimePart(Integer studentId, String timePart) {
        return mapper.countStudentCourseSelectedByTimePart(studentId, timePart);
    }

    public List<HotelAllOrderItemVO> listStudentTimetable(Integer studentId) {
        return mapper.listStudentTimetable(studentId);
    }
}
