package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.RestBean;
import com.example.elm_springboot_backend.entity.vo.CartListVo;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetListVo;
import com.example.elm_springboot_backend.service.OrderDetailetService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/orderdetailet")
public class OrderdetailetController {
    @Resource
    OrderDetailetService orderDetailetService;

    @PostMapping("/listOrderDetailet")
    public RestBean<List<OrderDetailetListVo>> listOrderDetailet(@RequestBody @Valid CartListVo vo){
        return RestBean.success(orderDetailetService.listOrderDetailet(vo));
    }
}

