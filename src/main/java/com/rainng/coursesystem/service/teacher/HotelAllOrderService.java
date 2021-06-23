package com.rainng.coursesystem.service.teacher;

import com.rainng.coursesystem.manager.teacher.TimetableManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.ManagerAllOrderItemVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelAllOrderService extends BaseService {
    private final TimetableManager manager;

    public HotelAllOrderService(TimetableManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(Integer Id) {
        Integer customerId = getUserId();
        return result(manager.getPageCount(customerId));
    }

    public ResultVO getPage(Integer index) {
        Integer managerId = getUserId();
        List<ManagerAllOrderItemVO> boList = manager.getPage(index, managerId);
        //List<CustomerOrderItemVO> voList = new ArrayList<>(boList.size());
        //
        //  for (CustomerOrderItemVO bo : boList) {
        //    CustomerOrderItemVO vo = new CustomerOrderItemVO();
        //    BeanUtils.copyProperties(bo, vo);
        //    vo.setTime(lessonTimeConverter.covertTimePart(bo.getTime()));
        //    voList.add(vo);
        //}

        return result(boList);
    }

}
