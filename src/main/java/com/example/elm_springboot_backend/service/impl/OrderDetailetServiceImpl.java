package com.example.elm_springboot_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.elm_springboot_backend.entity.dto.Cart;
import com.example.elm_springboot_backend.entity.dto.Food;
import com.example.elm_springboot_backend.entity.dto.OrderDetailet;
import com.example.elm_springboot_backend.entity.vo.CartListVo;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetListVo;
import com.example.elm_springboot_backend.entity.dto.OrderDetailetVo;
import com.example.elm_springboot_backend.mapper.CartMapper;
import com.example.elm_springboot_backend.mapper.FoodMapper;
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

    @Resource
    private CartMapper cartMapper;

    @Resource
    private FoodMapper foodMapper;

    //订单明细应该存的食物和数量是二维数组，与数据库不符，后续有时间再修改
    //在支付页面的订单明细直接由订单确认界面传给支付界面
    @Override
    public String saveOrderDetailet(OrderDetailetVo vo){
        return null;
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
