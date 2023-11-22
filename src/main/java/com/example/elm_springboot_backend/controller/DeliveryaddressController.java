package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.dto.DeliveryAddress;
import com.example.elm_springboot_backend.service.DeliveryAddressService;
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
@RequestMapping("/deliveryaddress")
public class DeliveryaddressController {

    @Resource
    private DeliveryAddressService deliveryAddressService;

    @RequestMapping("/listDeliveryAddressByUserId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(DeliveryAddress deliveryAddress)
            throws Exception{
        return deliveryAddressService.listDeliveryAddressByUserId(deliveryAddress.getUserId());
    }

    @RequestMapping("/getDeliveryAddressById")
    public DeliveryAddress getDeliveryAddressById(DeliveryAddress deliveryAddress) throws
            Exception{
        return deliveryAddressService.getDeliveryAddressById(deliveryAddress.getDaId());
    }

    @RequestMapping("/saveDeliveryAddress")
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception{
        return deliveryAddressService.saveDeliveryAddress(deliveryAddress);
    }

    @RequestMapping("/updateDeliveryAddress")
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception{
        return deliveryAddressService.updateDeliveryAddress(deliveryAddress);
    }

    @RequestMapping("/removeDeliveryAddress")
    public int removeDeliveryAddress(DeliveryAddress deliveryAddress) throws Exception{
        return deliveryAddressService.removeDeliveryAddress(deliveryAddress.getDaId());
    }

}

