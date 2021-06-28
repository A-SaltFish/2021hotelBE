package com.rainng.coursesystem.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rainng.coursesystem.dao.mapper.AdminManagerMapper;
import com.rainng.coursesystem.model.entity.ManagerEntity;
import com.rainng.coursesystem.model.vo.response.ManagerInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminManagerDAO extends BaseDAO {
    public static final int PAGE_SIZE = 20;

    private final AdminManagerMapper mapper;

    public AdminManagerDAO(AdminManagerMapper mapper) {
        this.mapper = mapper;
    }

    public int adminInsertManager(ManagerEntity entity) {
        return mapper.insert(entity);
    }

    //获取创建 的最新经理ID
    public Integer getPreManagerId(){
        return mapper.getPreManagerId();
    }


    public Integer setHotelIdByManager(Integer managerId,Integer hotelId){
        return mapper.setHotelIdByManager(managerId,hotelId);
    }
    //更新经历中酒店的ID
    public int updateManagerHotelId(ManagerEntity managerEntity){
        return mapper.updateById(managerEntity);
    }

    //统计售后订单
    public Integer countAdminCustomer(Integer managerId, String managerName) {
        System.out.println("managerId:"+managerId);
        System.out.println("managerName:"+managerName);
        return mapper.getManagerCount(managerId, managerName);
    }

    //获取售后订单
    public List<ManagerInfoVo> getManagerPage(Integer index, Integer managerId, String managerName) {
        Page<ManagerInfoVo> page = new Page<>(index, PAGE_SIZE);
        return mapper.getManagerPage(page, managerId, managerName).getRecords();
    }


    public int deleteManagerById(Integer managerId ) {
        return mapper.deleteManagerById(managerId);
    }

    public int passManagerById(Integer managerId ) {
        return mapper.passManagerById(managerId);
    }

    public int judge(Integer orderId){
        return mapper.changeStatusByOrderId(orderId,5);
    }

    public int getByHotelId(Integer hotelId) {
        LambdaQueryWrapper<ManagerEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ManagerEntity::getId,hotelId);
        return mapper.selectCount(wrapper);
    }
}
