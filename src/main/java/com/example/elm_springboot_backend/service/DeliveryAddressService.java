package com.example.elm_springboot_backend.service;

import com.example.elm_springboot_backend.entity.dto.DeliveryAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.elm_springboot_backend.entity.vo.DeliveryAddressVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
public interface DeliveryAddressService extends IService<DeliveryAddress> {
    List<DeliveryAddress> listDeliveryAddressByUserId(Integer userId);
    DeliveryAddress getDeliveryAddressById(Integer daId);
    String saveDeliveryAddress(DeliveryAddressVo vo);
    String updateDeliveryAddress(DeliveryAddress deliveryAddress);
    String removeDeliveryAddress(Integer daId);

}
