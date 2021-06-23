package com.rainng.coursesystem.service.admin;

import com.rainng.coursesystem.manager.admin.CourseManager;
import com.rainng.coursesystem.model.bo.OrderItemBo;
import com.rainng.coursesystem.model.entity.OrderEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.OrderItemVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.util.LessonTimeConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService extends BaseService {
    private final CourseManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public OrderService(CourseManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO getPageCount(String departmentName, String teacherName, String name) {
        return result(manager.getPageCount(departmentName, teacherName, name));
    }

    public ResultVO getPage(Integer index, String departmentName, String teacherName, String name) {
        List<OrderItemBo> boList = manager.getPage(index, departmentName, teacherName, name);
        List<OrderItemVO> voList = new ArrayList<>(boList.size());

        for (OrderItemBo bo : boList) {
            OrderItemVO vo = new OrderItemVO();
            BeanUtils.copyProperties(bo, vo);
            voList.add(vo);
        }

        return result(voList);
    }

    public ResultVO get(Integer id) {
        OrderEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("课程Id: " + id + "不存在!");
        }

        return result(entity);
    }

    public ResultVO update(OrderEntity entity) {
        OrderEntity origin = manager.get(entity.getId());
        if (origin == null) {
            return failedResult("课程Id: " + entity.getId() + "不存在!");
        }
        if (manager.getTeacherById(entity.getTeacherId()) == null) {
            return failedResult("授课教师Id: " + entity.getTeacherId() + "不存在!");
        }

        entity.setSelectedCount(origin.getSelectedCount());

        manager.update(entity);
        return result("更新成功");
    }

    public ResultVO delete(Integer id) {
        if (manager.get(id) == null) {
            return failedResult("课程Id: " + id + "不存在!");
        }
        if (manager.hasStudentCourse(id)) {
            return failedResult("还有学生未退选此课程");
        }

        manager.delete(id);
        return result("删除成功");
    }

    public ResultVO create(OrderEntity entity) {
        if (manager.get(entity.getId()) != null) {
            return failedResult("课程Id: " + entity.getId() + "已存在!");
        }
        if (manager.getTeacherById(entity.getTeacherId()) == null) {
            return failedResult("授课教师Id: " + entity.getTeacherId() + "不存在!");
        }

        manager.create(entity);
        return result("添加成功");
    }

    public ResultVO listName() {
        return result(manager.listName());
    }
}
