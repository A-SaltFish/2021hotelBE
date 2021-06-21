package com.rainng.coursesystem.service.student;

import com.rainng.coursesystem.manager.OptionManager;
import com.rainng.coursesystem.manager.student.OrderSelectManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.CustomerOrderItemVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.util.LessonTimeConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderSelectService extends BaseService {
    private final OrderSelectManager manager;
    private final OptionManager optionManager;
    private final LessonTimeConverter lessonTimeConverter;

    public OrderSelectService(OrderSelectManager manager, OptionManager optionManager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.optionManager = optionManager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO getPageCount(Integer Id) {
        Integer customerId = getUserId();
        return result(manager.getPageCount(customerId));
    }

    public ResultVO getPage(Integer index) {
        Integer customerId = getUserId();
        List<CustomerOrderItemVO> boList = manager.getPage(index, customerId);
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

    //客户订单不可视化
    public ResultVO deleteOrder(Integer orderId){
        return result(manager.deleteOrder(orderId));
    }

    public ResultVO showOrder(Integer orderId) {
        return result(manager.getExplicitOrderById(orderId));
    }

    private String splitTimePart(String time) {
        String[] spilt = time.split("-");
        return spilt[0] + "-" + spilt[1];
    }
}
