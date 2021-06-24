package com.rainng.coursesystem.service.admin;

import com.rainng.coursesystem.manager.admin.CustomerOrderManager;
import com.rainng.coursesystem.model.entity.OrderEntity;
import com.rainng.coursesystem.model.entity.CustomerOrderEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService extends BaseService {
    private final CustomerOrderManager manager;

    public CustomerOrderService(CustomerOrderManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(String className, String courseName, String studentName) {
        return result(manager.getPageCount(className, courseName, studentName));
    }

    public ResultVO getPage(Integer index) {
        Integer customerId=getUserId();
        return result(manager.getPage(index,customerId));
    }

    public ResultVO get(Integer id) {
        CustomerOrderEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("学生选课Id: " + id + "不存在!");
        }

        return result(entity);
    }

    public ResultVO update(CustomerOrderEntity entity) {
        CustomerOrderEntity originEntity = manager.get(entity.getId());
        if (originEntity == null) {
            return failedResult("学生选课Id: " + entity.getId() + "不存在!");
        }
        /*if (!originEntity.getCourseId().equals(entity.getCourseId())) {
            return failedResult("课程Id被篡改");
        }
        if (!originEntity.getStudentId().equals(entity.getStudentId())) {
            return failedResult("学生Id被篡改");
        }
        */
        manager.update(entity);
        return result("更新成功");
    }

    public ResultVO delete(Integer id) {
        CustomerOrderEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("学生选课Id: " + id + "不存在!");
        }

        manager.delete(entity);
        return result("删除成功");
    }


    public ResultVO create(CustomerOrderEntity entity) {
        if (manager.get(entity.getId()) != null) {
            return failedResult("学生选课Id: " + entity.getId() + "已存在!");
        }
        manager.create(entity);
        return result("添加成功");
    }

}
