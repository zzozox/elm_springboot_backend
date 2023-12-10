package com.example.elm_springboot_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.elm_springboot_backend.entity.dto.*;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetVo;
import com.example.elm_springboot_backend.entity.vo.CartListVo;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetListVo;
import com.example.elm_springboot_backend.mapper.*;
import com.example.elm_springboot_backend.service.BusinessService;
import com.example.elm_springboot_backend.service.FoodService;
import com.example.elm_springboot_backend.service.OrderDetailetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.elm_springboot_backend.service.OrdersService;
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
    @Resource
    private CartMapper cartMapper;
    @Resource
    private FoodMapper foodMapper;

    @Resource
    private FoodService foodService;
    @Resource
    private OrdersService ordersService;
    @Resource
    private BusinessService businessService;

    //在支付页面的订单明细直接由订单确认界面传给支付界面

    //以下方法主要用于OrderList组件
    @Override
    public List<OrderDetailetVo> listOrderDetailetbyUserId(Integer userId) {
        //根据UserId查询订单
        List<Orders> orders=ordersService.listOrdersByUserId(userId);
        List<OrderDetailetVo> orderDetailetVos=new ArrayList<>();
        //对于每条订单
        for (Orders order:orders) {
            List<OrderDetailetListVo> vos=new ArrayList<>();
            //查询数据库中该订单的的订单详情
            QueryWrapper<OrderDetailet> orderDetailetQueryWrapper = new QueryWrapper<>();
            orderDetailetQueryWrapper.eq("orderId",order.getOrderId());
            List<OrderDetailet> orderDetailets = orderDetailetMapper.selectList(orderDetailetQueryWrapper);
            //对orderDetailet里的食物信息通过foodId进行查询并赋值给orderDetailetListVo，然后把这个orderDetailetListVo添加到vos
            for (OrderDetailet orderDetailet : orderDetailets) {
                OrderDetailetListVo orderDetailetListVo=new OrderDetailetListVo();
                orderDetailetListVo.setFoodId(orderDetailet.getFoodId());
                orderDetailetListVo.setFoodName(foodService.getFoodById(orderDetailet.getFoodId()).getFoodName());
                orderDetailetListVo.setFoodImg(foodService.getFoodById(orderDetailet.getFoodId()).getFoodImg());
                orderDetailetListVo.setFoodPrice(foodService.getFoodById(orderDetailet.getFoodId()).getFoodPrice());
                orderDetailetListVo.setQuantity(orderDetailet.getQuantity());
                vos.add(orderDetailetListVo);
            }
            OrderDetailetVo orderDetailetVo=new OrderDetailetVo();
            orderDetailetVo.setOrders(order);
            orderDetailetVo.setBusiness(businessService.getBusinessById(order.getBusinessId()));
            orderDetailetVo.setOrderDetailetListVos(vos);
            orderDetailetVos.add(orderDetailetVo);
        }
        return orderDetailetVos;
    }



    @Override
    public List<OrderDetailetListVo> listOrderDetailet(CartListVo vo){
        QueryWrapper<Cart> cartQueryWrapper=new QueryWrapper<>();
        cartQueryWrapper.eq("userId",vo.getUserId())
                .eq("businessId",vo.getBusinessId());
        List<Cart> carts=cartMapper.selectList(cartQueryWrapper);
        List<OrderDetailetListVo> orderDetailetListVos=new ArrayList<>();
        for (Cart cart : carts) {
            Food food=foodMapper.selectById(cart.getFoodId());
            OrderDetailetListVo orderDetailetListVo = new OrderDetailetListVo();
            orderDetailetListVo.setFoodId(food.getFoodId());
            orderDetailetListVo.setFoodName(food.getFoodName());
            orderDetailetListVo.setFoodImg(food.getFoodImg());
            orderDetailetListVo.setFoodPrice(food.getFoodPrice());
            orderDetailetListVo.setQuantity(cart.getQuantity());
            orderDetailetListVos.add(orderDetailetListVo);
        }
        return orderDetailetListVos;
    }
}
