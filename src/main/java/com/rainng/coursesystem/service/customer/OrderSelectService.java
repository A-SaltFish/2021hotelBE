package com.rainng.coursesystem.service.customer;

import com.rainng.coursesystem.manager.customer.OrderSelectManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.CustomerOrderItemVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderSelectService extends BaseService {
    private final OrderSelectManager manager;


    public OrderSelectService(OrderSelectManager manager) {
        this.manager = manager;
    }

    public ResultVO getPageCount(Integer Id) {
        Integer customerId = getUserId();
        return result(manager.getPageCount(customerId));
    }

    public ResultVO getPage(Integer index) {
        Integer customerId = getUserId();
        List<CustomerOrderItemVO> boList = manager.getPage(index, customerId);
        return result(boList);
    }

    //客户订单不可视化
    public ResultVO deleteOrder(Integer orderId){
        return result(manager.deleteOrder(orderId));
    }

    public ResultVO showOrder(Integer orderId) {
        return result(manager.getExplicitOrderById(orderId));
    }

}
