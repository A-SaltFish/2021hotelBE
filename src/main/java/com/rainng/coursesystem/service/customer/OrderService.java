package com.rainng.coursesystem.service.customer;

import com.rainng.coursesystem.manager.customer.PreOrderManager;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service("customer_service")
public class OrderService extends BaseService {
    private final PreOrderManager manager;

    public OrderService(PreOrderManager manager) {
        this.manager = manager;
    }

    public ResultVO list() {
        Integer customerId = getUserId();
        System.out.println("當前customer ID為"+customerId);
        return result(manager.listCustomerPreOrder(customerId));
    }

    public ResultVO cancelOrder(Integer OrderId){
        if (manager.cancelOrder(OrderId))
            return result("取消成功！");
        else return result("取消失败！");
    }

    public ResultVO refund(Integer orderId,String reason) {
        if(manager.refund(orderId,reason)>0)
            return result("申请退单成功！");
        return result("申请失败");
    }

    public ResultVO remark(Integer orderId,String comment,Integer rank) {
        if(manager.remark(orderId,comment,rank)>0)
            return result("评论订单成功！");
        return result("评论失败");
    }
}
