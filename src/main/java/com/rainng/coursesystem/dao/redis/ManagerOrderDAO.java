package com.rainng.coursesystem.dao.redis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainng.coursesystem.dao.BaseDAO;
import com.rainng.coursesystem.dao.mapper.ManagerOrderMapper;
import com.rainng.coursesystem.model.entity.ManagerOrderEntity;
import com.rainng.coursesystem.model.vo.response.table.HotelAllOrderItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerOrderDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final ManagerOrderMapper mapper;

    public ManagerOrderDAO(ManagerOrderMapper mapper) {
        this.mapper = mapper;
    }

    public List<HotelAllOrderItemVO> getPage(Integer index, Integer managerId) {
        Page<HotelAllOrderItemVO> page = new Page<>(index, PAGE_SIZE);

        return mapper.getPage(page, managerId).getRecords();
    }

    //统计售后订单
    public Integer countAfterSales(Integer managerId, Integer orderId, String roomName) {
        System.out.println("orderId:"+orderId);
        System.out.println("roomName:"+roomName);
        return mapper.countAfterSales(managerId, orderId, roomName);
    }

    //获取售后订单
    public List<HotelAllOrderItemVO> getAfterSalesPage(Integer index, Integer managerId, Integer orderId, String roomName) {
        Page<HotelAllOrderItemVO> page = new Page<>(index, PAGE_SIZE);
        System.out.println("orderId2:"+orderId);
        System.out.println("roomName2:"+roomName);
        return mapper.getAfterSalesPage(page, managerId, orderId, roomName).getRecords();
    }

    public Integer getHotelIdByManagerId(Integer managerId){
        return mapper.getHotelIdByManagerId(managerId);
    }

    public int getByHotelId(Integer hotelId) {
        LambdaQueryWrapper<ManagerOrderEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ManagerOrderEntity::getHotelId,hotelId);
        return mapper.selectCount(wrapper);
    }
}
