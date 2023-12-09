package com.example.elm_springboot_backend.service;

import com.example.elm_springboot_backend.entity.dto.OrderDetailet;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.elm_springboot_backend.entity.vo.CartListVo;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetListVo;
import com.example.elm_springboot_backend.entity.dto.OrderDetailetVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
public interface OrderDetailetService extends IService<OrderDetailet> {
    String saveOrderDetailet(OrderDetailetVo vo);
    List<OrderDetailetListVo> listOrderDetailet(CartListVo vo);
}
