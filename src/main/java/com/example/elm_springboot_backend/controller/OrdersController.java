package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.dto.Orders;
import com.example.elm_springboot_backend.service.OrdersService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    @RequestMapping("/createOrders")
    public int createOrders(Orders orders) throws Exception{
        return ordersService.createOrders(orders);
    }

    @RequestMapping("/getOrdersById")
    public Orders getOrdersById(Orders orders) throws Exception{
        return ordersService.getOrdersById(orders.getOrderId());
    }

    @RequestMapping("/listOrdersByUserId")
    public List<Orders> listOrdersByUserId(Orders orders) throws Exception {
        return ordersService.listOrdersByUserId(orders.getUserId());
    }
}

