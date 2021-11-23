package com.imooc.cloud.mall.practice.cartorder.service;

import com.github.pagehelper.PageInfo;
import com.imooc.cloud.mall.practice.cartorder.model.pojo.Order;
import com.imooc.cloud.mall.practice.cartorder.model.request.CreateOrderReq;
import com.imooc.cloud.mall.practice.cartorder.model.vo.OrderVO;

import java.util.List;

/**
 * 描述：     订单Service
 */
public interface OrderService {


    String create(CreateOrderReq createOrderReq);

    OrderVO detail(String orderNo);

    PageInfo listForCustomer(Integer pageNum, Integer pageSize);

    void cancel(String orderNo, Boolean isFromSystem);

    String qrcode(String orderNo);

    void pay(String orderNo);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    void deliver(String orderNo);

    void finish(String orderNo);

    List<Order> getUnpaidOrders();
}
