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

//    @GetMapping("/getName")//通过id获取酒店名称
//    public String getName(@Param("hotel_id") Integer hotel_id){
//        TSearch tSearch = tSearchService.findById(hotel_id);
//        return tSearch.getHotel_name();
//    }
//
//    @GetMapping("/getId")
//    public Integer getId(@Param("hotel_name") String hotel_name){
//        TSearch tSearch = tSearchService.findByName(hotel_name);
//        return tSearch.getHotel_id();
//
//    }
    @GetMapping("/getId")//通过酒店名称获取id
    public List<TSearch> getId(@Param("hotel_name") String hotel_name){
        List<TSearch> list = tSearchService.findByName(hotel_name);
        return list;
    }

    @GetMapping("/hotels")//通过城市获取酒店
    public List<TSearch> getName(@Param("ht_city_name") String ht_city_name){
        List<TSearch> list = tSearchService.findByCity(ht_city_name);
        return list;
    }

//    @GetMapping("/getJson")//通过name获取id
//    public String getJson(@Param("hotel_id") Integer hotel_id ){
//        TSearch tSearch = tSearchService.findById(hotel_id);
//        Gson gson = new Gson();
//        return gson.toJson(tSearch);
//    }
//    @GetMapping("/getAll")
//    public List<TSearch> getAll(){
//        List<TSearch> list = tSearchService.findTSearchAll();
//        return list;
//    }
//
//    @GetMapping("/getAllJson")//同上 返回json数据格式
//    public String getAllJson(){
//        List<TSearch> list = tSearchService.findTSearchAll();
//        Gson gson = new Gson();
//        return gson.toJson(list);
//    }



}
