//package com.example.elm_springboot_backend.service.impl;
//
//import com.example.elm_springboot_backend.entity.dto.Cart;
//import com.example.elm_springboot_backend.entity.dto.OrderDetailet;
//import com.example.elm_springboot_backend.entity.dto.Orders;
//import com.example.elm_springboot_backend.mapper.CartMapper;
//import com.example.elm_springboot_backend.mapper.OrderDetailetMapper;
//import com.example.elm_springboot_backend.mapper.OrdersMapper;
//import com.example.elm_springboot_backend.service.OrdersService;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import jakarta.annotation.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * <p>
// *  服务实现类
// * </p>
// *
// * @author root
// * @since 2023-09-21
// */
//@Service
//public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
//    @Resource
//    private CartMapper cartMapper;
//    @Autowired
//    private OrdersMapper ordersMapper;
//    @Autowired
//    private OrderDetailetMapper orderDetailetMapper;
//    @Override
//    @Transactional
//    public int createOrders(Orders orders) {
//        //1、查询当前用户购物车中当前商家的所有食品
//        Cart cart = new Cart();
//        cart.setUserId(orders.getUserId());
//        cart.setBusinessId(orders.getBusinessId());
//        List<Cart> cartList = cartMapper.listCart(cart);
//
//        //2、创建订单（返回生成的订单编号）
//        orders.setOrderDate(CommonUtil.getCurrentDate());
//        ordersMapper.saveOrders(orders);
//        int orderId = orders.getOrderId();
//
//        //3、批量添加订单明细
//        List<OrderDetailet> list = new ArrayList<>();
//        for(Cart c : cartList) {
//            OrderDetailet od = new OrderDetailet();
//            od.setOrderId(orderId);
//            od.setFoodId(c.getFoodId());
//            od.setQuantity(c.getQuantity());
//            list.add(od);
//        }
//        orderDetailetMapper.saveOrderDetailetBatch(list);
//
//        //4、从购物车表中删除相关食品信息
//        cartMapper.removeCart(cart);
//
//        return orderId;
//    }
//
//    @Override
//    public Orders getOrdersById(Integer orderId) {
//        return ordersMapper.getOrdersById(orderId);
//    }
//
//    @Override
//    public List<Orders> listOrdersByUserId(String userId){
//        return ordersMapper.listOrdersByUserId(userId);
//    }
//}
