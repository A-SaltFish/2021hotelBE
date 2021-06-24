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

    public Integer getHotelIdByManagerId(Integer managerId){
        return mapper.getHotelIdByManagerId(managerId);
    }

    public int getByHotelId(Integer hotelId) {
        LambdaQueryWrapper<ManagerOrderEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ManagerOrderEntity::getHotelId,hotelId);
        return mapper.selectCount(wrapper);
    }
}
