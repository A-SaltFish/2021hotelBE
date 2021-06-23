package com.rainng.coursesystem.dao.mapper;

import com.rainng.coursesystem.model.entity.Search;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SearchMapper {
    //    按要求查找设备
    public List<Search> findByRequired(Search search);
}
