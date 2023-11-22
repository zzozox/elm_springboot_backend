package com.example.elm_springboot_backend.service;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.example.elm_springboot_backend.entity.dto.Business;
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
public interface BusinessService extends IService<Business> {
    List<Business> getAllBusinesses();
    List<Business> listBusinessesByOrderTypeId(Integer orderTypeId);
    Business getBusinessById(Integer businessId);
}
