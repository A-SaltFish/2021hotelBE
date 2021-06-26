package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainng.coursesystem.dao.mapper.ManagerMapper;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelPreOrderItemVO;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final ManagerMapper mapper;

    public ManagerDAO(ManagerMapper mapper) {
        this.mapper = mapper;
    }

    public int insert(ManagerEntity entity) {
        return mapper.insert(entity);
    }

    public int delete(Integer id) {
        return mapper.deleteById(id);
    }

    public ManagerEntity get(Integer id) {
        return mapper.selectById(id);
    }

    public int update(ManagerEntity entity) {
        return mapper.updateById(entity);
    }

    public int count(String departmentName, String name) {
        return mapper.count(departmentName, name);
    }

    public List<TeacherItemVO> getPage(Integer index, String departmentName, String name){
        return null;
    }

    public ManagerEntity getById(String id) {
        LambdaQueryWrapper<ManagerEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ManagerEntity::getId, id);

        return mapper.selectOne(wrapper);
    }

    public Integer countByDepartmentId(Integer departmentId) {
        LambdaQueryWrapper<ManagerEntity> wrapper = new LambdaQueryWrapper<>();
        //wrapper.eq(ManagerEntity::getDepartmentId, departmentId);

        return mapper.selectCount(wrapper);
    }

    public List<ManagerEntity> listName() {
        LambdaQueryWrapper<ManagerEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(ManagerEntity::getId, ManagerEntity::getName);

        return mapper.selectList(wrapper);
    }


    public List<HotelPreOrderItemVO> HotelPreList(Integer managerId) {
        return mapper.HotelPreList(managerId);
    }
}
