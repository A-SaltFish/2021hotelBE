package com.rainng.coursesystem.service;

import com.rainng.coursesystem.model.entity.TSearch;

import java.util.List;

public interface TSearchService {
     List<TSearch> findById(Integer hotel_id);
     List<TSearch> findByCity(String city_name);
//    public List<TSearch> findTSearchAll(Search search);//城市名称和星级进行筛选

}
