package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainng.coursesystem.dao.mapper.CustomerMapper;
import com.rainng.coursesystem.model.entity.CustomerEntity;
import com.rainng.coursesystem.model.vo.response.CustomerInfoVo;
import com.rainng.coursesystem.model.vo.response.table.StudentItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;
    private final CustomerMapper mapper;

    public CustomerDAO(CustomerMapper mapper) {
        this.mapper = mapper;
    }

    public CustomerEntity getById(String id) {
        LambdaQueryWrapper<CustomerEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CustomerEntity::getId, id);

        return mapper.selectOne(wrapper);
    }


    public int insert(CustomerEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public CustomerEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(CustomerEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String majorName, String className, String name) {
        return mapper.count(majorName, className, name);
    }

    public List<StudentItemVO> getPage(Integer index, String majorName, String className, String name) {
        Page<StudentItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, majorName, className, name).getRecords();
    }


    public List<CustomerEntity> listName() {
        LambdaQueryWrapper<CustomerEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(CustomerEntity::getId, CustomerEntity::getName);

        return mapper.selectList(wrapper);
    }


    public CustomerInfoVo getStudentInfoById(Integer studentId) {
        return mapper.getStudentInfoById(studentId);
    }
}
