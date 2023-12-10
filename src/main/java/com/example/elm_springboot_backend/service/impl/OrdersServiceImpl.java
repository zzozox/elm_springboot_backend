package com.example.elm_springboot_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.elm_springboot_backend.entity.dto.*;
import com.example.elm_springboot_backend.entity.vo.OrderVo;
import com.example.elm_springboot_backend.mapper.CartMapper;
import com.example.elm_springboot_backend.mapper.OrderDetailetMapper;
import com.example.elm_springboot_backend.mapper.OrdersMapper;
import com.example.elm_springboot_backend.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private CartMapper cartMapper;

    @Resource
    private OrderDetailetMapper orderDetailetMapper;


    @Override
    public Orders saveOrders(OrderVo vo) {
        Orders orders=new Orders(
                null,
                vo.getUserId(),
                vo.getBusinessId(),
                LocalDateTime.now().toString(),
                vo.getOrderTotal(),
                vo.getDaId(),
                0);
        if(ordersMapper.insert(orders)==1) {
            //在生成订单的同时再生成订单明细
            //订单明细应该存的食物和数量是二维数组，与数据库不符，后续有时间再修改
            //在支付页面的订单明细直接由订单确认界面传给支付界面
            //OrderDetailet orderDetailet=new OrderDetailet();
            //因为OrderList界面一定会用到订单明细，不能再由Order组件传值，被迫在数据库加表存储订单明细
            //先查购物车里的食物
            QueryWrapper<Cart> cartQueryWrapper = new QueryWrapper<>();
            cartQueryWrapper.eq("userId", orders.getUserId())
                    .eq("businessId", orders.getBusinessId());
            List<Cart> carts=cartMapper.selectList(cartQueryWrapper);
            for(Cart cart : carts){
                OrderDetailet orderDetailet=new OrderDetailet(
                    null,
                    orders.getOrderId(),
                    cart.getFoodId(),
                    cart.getQuantity()
                );
                orderDetailetMapper.insert(orderDetailet);
            }
            //订单生成成功后删除购物车记录，即该用户在该商家下的购物车记录
            cartMapper.delete(cartQueryWrapper);
            //文档上写的返回订单编号，虽然但是，能跑就行，暂时不改
            return orders;
        }else {
            return null;
        }
    }

    @Override
    public Orders getOrdersById(Integer orderId) {
        return ordersMapper.selectById(orderId);
    }

    @Override
    public List<Orders> listOrdersByUserId(Integer userId) {
        QueryWrapper<Orders> ordersQueryWrapper=new QueryWrapper<>();
        ordersQueryWrapper.eq("userId",userId);
        return ordersMapper.selectList(ordersQueryWrapper);
    }
}
