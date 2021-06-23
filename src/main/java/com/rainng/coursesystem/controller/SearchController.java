package com.rainng.coursesystem.controller;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.rainng.coursesystem.model.entity.Search;
import com.rainng.coursesystem.dao.SearchDao;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/find_searches_required")
@RestController

//@PostMapping("/find_searches_required")
public class SearchController {
    public String find_searches_required(@RequestParam("hotel_city") String hotel_city,
                                          @RequestParam("hotel_name") String hotel_name,
                                          @RequestParam("hotel_rank") Float hotel_rank,
                                          @RequestParam("room_type") Integer room_type,
                                          @RequestParam("rm_breakfast_type") Integer rm_breakfast_type,
//                                          @RequestParam("hotel_longitude") Float hotel_longitude,
//                                          @RequestParam("hotel_latitude") Float hotel_latitude,
                                          Model model){
        Search search=new Search();
        search.setHotel_city(hotel_city);
        search.setHotel_name(hotel_name);
        search.setHotel_rank(hotel_rank);
        search.setRoom_type(room_type);
        search.setRm_breakfast_type(rm_breakfast_type);
        SearchDao searchesDao = new SearchDao();
        Collection<Search> searches =searchesDao.getRequired(search);
        System.out.println(searches);
      //  model.addAttribute("searches",searches);
        return "searches/searches";

    }


}
