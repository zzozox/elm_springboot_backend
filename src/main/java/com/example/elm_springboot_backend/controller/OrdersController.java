package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.RestBean;
import com.example.elm_springboot_backend.entity.dto.Orders;
import com.example.elm_springboot_backend.entity.vo.OrderVo;
import com.example.elm_springboot_backend.service.OrdersService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
/**
 * orders相关Controller
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    /**
     * 创建订单
     * @param vo
     * @return
     */
    @PostMapping("/createOrders")
    public RestBean<Orders> createOrders(@RequestBody @Valid OrderVo vo){
        return RestBean.success(ordersService.saveOrders(vo));
    }

    /**
     * 根据订单编号查询订单
     * @param orderId
     * @return
     */
    @PostMapping("/getOrdersById/{orderId}")
    public RestBean<Orders> getOrdersById(@PathVariable Integer orderId){
        return RestBean.success(ordersService.getOrdersById(orderId));
    }

    /**
     * 根据用户id查询用户所有订单
     * @param userId
     * @return
     */
    @PostMapping("/listOrdersByUserId/{userId}")
    public RestBean<List<Orders>> listOrdersByUserId(@PathVariable Integer userId){
        return RestBean.success(ordersService.listOrdersByUserId(userId));
    }

    private <T> RestBean<T> messageHandle(Supplier<String> action){
        String message = action.get();
        if(message == null)
            return RestBean.success();
        else
            return RestBean.failure(400, message);
    }
}

