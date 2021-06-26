package com.rainng.coursesystem.service;

public interface CustomerOrderService {
     int insertByOid(Integer id, Integer customerId, Integer hotelId, Integer roomId, Integer ctime, Integer status, Integer ifShow, String reason);
}
