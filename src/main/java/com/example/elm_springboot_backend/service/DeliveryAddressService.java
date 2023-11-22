package com.example.elm_springboot_backend.service;

import com.example.elm_springboot_backend.entity.dto.DeliveryAddress;
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
public interface DeliveryAddressService extends IService<DeliveryAddress> {
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
    public DeliveryAddress getDeliveryAddressById(Integer daId);
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress);
    public int removeDeliveryAddress(Integer daId);

}
