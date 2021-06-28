package com.rainng.coursesystem.controller;

import com.rainng.coursesystem.model.entity.TSearch;
import com.rainng.coursesystem.service.TSearchService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class TSearchController {

    @Autowired
        private TSearchService tSearchService;


    @GetMapping("/hotel_id")//通过酒店id获取酒店
    public List<TSearch> getId(@Param("hotel_id") Integer hotel_id){
        List<TSearch> list = tSearchService.findById(hotel_id);
        System.out.println(list);
        return list;
    }


    @GetMapping("/hotels")//通过城市获取酒店
    public List<TSearch> getName(@Param("ht_city_name") String ht_city_name){
        List<TSearch> list = tSearchService.findByCity(ht_city_name);
        System.out.println(list);
        return list;
    }



}
