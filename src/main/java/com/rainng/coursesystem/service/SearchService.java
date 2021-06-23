package com.rainng.coursesystem.service;

import com.rainng.coursesystem.model.entity.Search;

import java.util.List;



public interface SearchService {
    //    按要求查找
    public List<Search> findByRequired(Search search);
}

