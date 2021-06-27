package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainng.coursesystem.dao.mapper.ManagerMapper;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelPreOrderItemVO;
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

    public ManagerEntity getById(String id) {
        LambdaQueryWrapper<ManagerEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ManagerEntity::getId, id);

        return mapper.selectOne(wrapper);
    }

}
