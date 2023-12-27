package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.RestBean;
import com.example.elm_springboot_backend.entity.dto.DeliveryAddress;
import com.example.elm_springboot_backend.entity.vo.DeliveryAddressVo;
import com.example.elm_springboot_backend.service.DeliveryAddressService;
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
 * deliveryaddress相关Controller
 */
@RestController
@RequestMapping("/deliveryaddress")
public class DeliveryaddressController {

    @Resource
    private DeliveryAddressService deliveryAddressService;

    @PostMapping ("/listDeliveryAddressByUserId/{userId}")
    public RestBean<List<DeliveryAddress>> listDeliveryAddressByUserId(@PathVariable Integer userId){
        return RestBean.success(deliveryAddressService.listDeliveryAddressByUserId(userId));
    }

    @PostMapping("/getDeliveryAddressById/{daId}")
    public RestBean<DeliveryAddress> getDeliveryAddressById(@PathVariable Integer daId){
        return RestBean.success(deliveryAddressService.getDeliveryAddressById(daId));
    }

    @PostMapping("/saveDeliveryAddress")
    public RestBean<Void> saveDeliveryAddress(@RequestBody @Valid DeliveryAddressVo vo){
        return this.messageHandle(() ->
                deliveryAddressService.saveDeliveryAddress(vo));
    }

    @PostMapping("/updateDeliveryAddress")
    public RestBean<Void> updateDeliveryAddress(@RequestBody @Valid DeliveryAddress deliveryAddress){
        return this.messageHandle(() ->
                deliveryAddressService.updateDeliveryAddress(deliveryAddress));
    }

    @PostMapping("/removeDeliveryAddress/{daId}")
    public RestBean<Void> removeDeliveryAddress(@PathVariable Integer daId){
        return this.messageHandle(() ->
                deliveryAddressService.removeDeliveryAddress(daId));
    }

    private <T> RestBean<T> messageHandle(Supplier<String> action){
        String message = action.get();
        if(message == null)
            return RestBean.success();
        else
            return RestBean.failure(400, message);
    }
}

