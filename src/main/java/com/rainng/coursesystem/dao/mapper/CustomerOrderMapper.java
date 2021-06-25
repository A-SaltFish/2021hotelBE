package com.rainng.coursesystem.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderMapper extends BaseMapper<CustomerOrderEntity> {

    Integer count(@Param("className")String className, @Param("courseName")String courseName, @Param("studentName")String studentName);

    Boolean deleteByOrderId(@Param("orderId")Integer orderId);

    Boolean cancelByOrderId(@Param("orderId")Integer orderId);

    IPage<CustomerOrderItemVO> getPage(IPage<CustomerOrderItemVO> page, @Param("customerId")Integer customerId);

    Integer countTeacherGrade(@Param("teacherId")Integer teacherId,@Param("courseName") Integer courseName,@Param("studentName") String studentName);

    IPage<TeacherGradeItemVO> getTeacherGradePage(IPage<TeacherGradeItemVO> page, @Param("teacherId")Integer teacherId, @Param("courseName")String courseName,@Param("studentName") String studentName);

    List<CustomerPreOrderVO> listCustomerPreOrder(Integer studentId);

    List<StudentExamItemVO> listStudentExam(Integer studentId);

    Integer countStudentCourseSelectedByTimePart(@Param("studentId")Integer studentId,@Param("timePart") String timePart);

    List<HotelAllOrderItemVO> listStudentTimetable(Integer studentId);
}
