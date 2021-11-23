package com.imooc.cloud.mall.practice.cartorder.model.dao;

import com.imooc.cloud.mall.practice.cartorder.model.pojo.Order;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByOrderNo(String orderNo);

    List<Order> selectForCustomer(Integer userId);

    List<Order> selectAllForAdmin();

    List<Order> selectUnpaidOrders(@Param("begTime") Date begTime, @Param("endTime") Date endTime);
}