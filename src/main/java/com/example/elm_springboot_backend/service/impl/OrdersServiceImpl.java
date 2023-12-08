package com.example.elm_springboot_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.elm_springboot_backend.entity.dto.Orders;
import com.example.elm_springboot_backend.entity.vo.OrderVo;
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

    @Override
    public String saveOrders(OrderVo vo) {
        Orders orders=new Orders(
                null,
                vo.getUserId(),
                vo.getBusinessId(),
                LocalDateTime.now().toString(),
                vo.getOrderTotal(),
                vo.getDaId(),
                vo.getOrderState());
        if(ordersMapper.insert(orders)==1){
            return null;
        }else {
            return "保存订单成功";
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
