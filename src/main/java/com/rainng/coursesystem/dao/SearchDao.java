package com.rainng.coursesystem.dao;

import com.rainng.coursesystem.model.entity.Search;
//import com.rainng.coursesystem.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
//public class SearchDao {
//    @Autowired
//    SearchService searchService;
//
//    Map<String, Search> map=null;
//    //    按照要求查询
//    public Map<String, Search>getRequiredmap(Search search){
//        map=new HashMap<>();
//        List<Search> searches =searchService.findByRequired(search);
//        System.out.println(searches.size());
//        for(int i = 0; i< searches.size(); i++){
//            map.put(searches.get(i).getHotel_name(), searches.get(i));
//        }
//        return map;
//    }
//    //    按照要求查询
//    public Collection<Search>getRequired(Search search){
//        this.getRequiredmap(search);
//        return map.values();
//    }
//
//}