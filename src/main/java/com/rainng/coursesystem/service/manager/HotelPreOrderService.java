package com.rainng.coursesystem.service.manager;

import com.rainng.coursesystem.manager.manager.HotelPreOrderManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.HotelPreOrderItemVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.util.LessonTimeConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacher_courseService")
public class HotelPreOrderService extends BaseService {
    private final HotelPreOrderManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public HotelPreOrderService(HotelPreOrderManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO list() {
        Integer managerId = getUserId();

        List<HotelPreOrderItemVO> list = manager.HotelPreList(managerId);

        return result(list);
    }
}
