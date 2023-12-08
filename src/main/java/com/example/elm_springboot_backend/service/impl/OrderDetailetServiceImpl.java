package com.example.elm_springboot_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.elm_springboot_backend.entity.dto.OrderDetailet;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetVo;
import com.example.elm_springboot_backend.mapper.OrderDetailetMapper;
import com.example.elm_springboot_backend.service.OrderDetailetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@Service
public class OrderDetailetServiceImpl extends ServiceImpl<OrderDetailetMapper, OrderDetailet> implements OrderDetailetService {
    @Resource
    OrderDetailetMapper orderDetailetMapper;

    @Override
    public String saveOrderDetailetBatch(List<OrderDetailetVo> vos){
        List<OrderDetailet> list=new ArrayList<>();
        return null;
    }

    @Override
    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderId){
        QueryWrapper<OrderDetailet> orderDetailetQueryWrapper=new QueryWrapper<>();
        orderDetailetQueryWrapper.eq("orderId",orderId);
        return orderDetailetMapper.selectList(orderDetailetQueryWrapper);
    }
}
