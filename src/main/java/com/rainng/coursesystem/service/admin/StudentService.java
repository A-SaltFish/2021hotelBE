package com.rainng.coursesystem.service.admin;

import com.rainng.coursesystem.manager.admin.StudentManager;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends BaseService {
    private final StudentManager manager;
    private final UserService userService;

    public StudentService(StudentManager manager, UserService userService) {
        this.manager = manager;
        this.userService = userService;
    }

    public ResultVO getPageCount(String majorName, String className, String name) {
        return result(manager.getPageCount(majorName, className, name));
    }

    public ResultVO getPage(Integer index, String majorName, String className, String name) {
        return result(manager.getPage(index, majorName, className, name));
    }

    public ResultVO get(Integer id) {
        CustomerEntity entity = manager.get(id);
        if (entity == null) {
            return failedResult("学生Id: " + id + "不存在!");
        }

        entity.setPassword("");

        return result(entity);
    }

    public ResultVO update(CustomerEntity entity) {
        CustomerEntity origin = manager.get(entity.getId());
        if (origin == null) {
            return failedResult("顾客ID: " + entity.getId() + "不存在!");
        }

   //     if (entity.getPassword().equals("")) {
            entity.setPassword(origin.getPassword());
   //     } else {
    //        entity.setPassword(userService.computePasswordHash(entity.getPassword()));
     //   }

        manager.update(entity);
        return result("更新成功");
    }

    public ResultVO delete(Integer id) {
        if (manager.get(id) == null) {
            return failedResult("学生Id: " + id + "不存在!");
        }
        if (manager.hasStudentCourse(id)) {
            return failedResult("此学生还有未退选课程");
        }

        manager.delete(id);
        return result("删除成功");
    }

    public ResultVO create(CustomerEntity entity) {
        if (manager.get(entity.getId()) != null) {
            return failedResult("顾客ID: " + entity.getId() + "已存在!");
        }

        manager.create(entity);
        return result("添加成功");
    }

    public ResultVO listName() {
        return result(manager.listName());
    }
}
