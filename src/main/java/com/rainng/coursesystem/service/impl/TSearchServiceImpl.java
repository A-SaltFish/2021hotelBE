package com.rainng.coursesystem.service.impl;

import com.rainng.coursesystem.dao.mapper.TSearchMapper;
import com.rainng.coursesystem.model.entity.TSearch;
import com.rainng.coursesystem.service.TSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TSearchServiceImpl implements TSearchService {
    @Autowired
    private TSearchMapper tSearchMapper;

    @Override
    public List<TSearch> findById(Integer hotel_id){
        return tSearchMapper.findById(hotel_id);
    }

    @Override
    public List<TSearch> findByCity(String ht_city_name){
        return tSearchMapper.findByCity(ht_city_name);
    }

//    @Override
//        public List<TSearch> findTSearchAll(){
//        return tSearchMapper.findTSearchAll();
//    }

}
