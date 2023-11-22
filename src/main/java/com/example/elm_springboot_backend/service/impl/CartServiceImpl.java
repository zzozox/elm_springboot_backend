package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.dto.Cart;
import com.example.elm_springboot_backend.mapper.CartMapper;
import com.example.elm_springboot_backend.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {
    @Resource
    CartMapper cartMapper;

    /**
     * 返回购物车中的商品
     * @param cart
     * @return
     */
    @Override
    public List<Cart> listCart(Cart cart) {
        return list();
    }


    @Override
    public int saveCart(Cart cart) {
        return cartMapper.saveCart(cart);
    }

    @Override
    public int updateCart(Cart cart) {
        return cartMapper.updateCart(cart);
    }

    @Override
    public int removeCart(Cart cart) {
        return cartMapper.removeCart(cart);
    }
}
