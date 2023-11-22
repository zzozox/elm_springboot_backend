package com.example.elm_springboot_backend.service;

import com.example.elm_springboot_backend.entity.dto.Cart;
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
public interface CartService extends IService<Cart> {
    public List<Cart> listCart(Cart cart);
    public int saveCart(Cart cart);
    public int updateCart(Cart cart);
    public int removeCart(Cart cart);
}
