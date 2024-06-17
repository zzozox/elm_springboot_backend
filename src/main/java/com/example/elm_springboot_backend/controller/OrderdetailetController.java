package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.RestBean;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetVo;
import com.example.elm_springboot_backend.entity.vo.CartListVo;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetListVo;
import com.example.elm_springboot_backend.service.OrderDetailetService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
/**
 * orderdetailet相关Controller
 */
@RestController
@RequestMapping("/orderdetailet")
public class OrderdetailetController {
    @Resource
    OrderDetailetService orderDetailetService;

    /**
     * 订单界面的订单订单详情
     * Order组件的
     * @param vo
     * @return
     */
    @PostMapping("/listOrderDetailet")
    public RestBean<List<OrderDetailetListVo>> listOrderDetailet(@RequestBody @Valid CartListVo vo){
        return RestBean.success(orderDetailetService.listOrderDetailet(vo));
    }

    /**
     * 列出所有订单的订单详情
     * OderList组件的
     * @param userId
     * @return
     */
    @PostMapping("/listOrderDetailetbyUserId/{userId}")
    public RestBean<List<OrderDetailetVo>> listOrderDetailetbyUserId(@PathVariable Integer userId){
        return RestBean.success(orderDetailetService.listOrderDetailetbyUserId(userId));
    }
}

