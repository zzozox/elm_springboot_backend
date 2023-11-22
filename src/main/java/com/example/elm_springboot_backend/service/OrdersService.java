package com.example.elm_springboot_backend.service;

import com.example.elm_springboot_backend.entity.dto.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
public interface OrdersService extends IService<Orders> {

    public int createOrders(Orders orders);
    public Orders getOrdersById(Integer orderId);
    public List<Orders> listOrdersByUserId(String userId);

}
