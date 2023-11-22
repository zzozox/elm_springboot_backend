package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.dto.Cart;
import com.example.elm_springboot_backend.entity.dto.DeliveryAddress;
import com.example.elm_springboot_backend.service.CartService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartService cartService;

    @RequestMapping("/listCart")
    public List<Cart> listCart(Cart cart) throws Exception{
        return cartService.listCart(cart);
    }

    @RequestMapping("/saveCart")
    public int saveCart(Cart cart) throws Exception{
        return cartService.saveCart(cart);
    }

    @RequestMapping("/updateCart")
    public int updateCart(Cart cart) throws Exception{
        return cartService.updateCart(cart);
    }

    @RequestMapping("/removeCart")
    public int removeCart(Cart cart) throws Exception{
        return cartService.removeCart(cart);
    }
}

