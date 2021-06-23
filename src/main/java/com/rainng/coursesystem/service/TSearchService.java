package com.rainng.coursesystem.service;

import com.rainng.coursesystem.model.entity.TSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TSearchService {
    public TSearch findById(Integer hotel_id);
    public TSearch findByName(String hotel_name);
    public List<TSearch> findTSearchAll();
}
