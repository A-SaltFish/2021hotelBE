package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rainng.coursesystem.dao.mapper.ManagerMapper;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final ManagerMapper mapper;

    public ManagerDAO(ManagerMapper mapper) {
        this.mapper = mapper;
    }

    public ManagerEntity getById(String id) {
        QueryWrapper<ManagerEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("manager_id", id);
        if(mapper.selectOne(wrapper)==null){
            QueryWrapper<ManagerEntity> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("manager_email", id);
            return mapper.selectOne(wrapper1);
        }
        return mapper.selectOne(wrapper);
    }

}
