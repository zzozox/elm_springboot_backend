package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.RestBean;
import com.example.elm_springboot_backend.entity.dto.Cart;
import com.example.elm_springboot_backend.entity.vo.CartListVo;
import com.example.elm_springboot_backend.entity.vo.CartVo;
import com.example.elm_springboot_backend.service.CartService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

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

    @PostMapping("/listCartByUserId/{userId}")
    public RestBean<List<Cart>> listCartByUserId(@PathVariable Integer userId){
        return RestBean.success(cartService.listCartByAccountId(userId));
    }
    @PostMapping("/listCartByUserIdAndBusinessId")
    public RestBean<List<Cart>> listCartByUserIdAndBusinessId(@RequestBody @Valid CartListVo vo){
        return RestBean.success(cartService.listCartByAccountIdAndBusinessId(vo));
    }
    @PostMapping("/saveCart")
    public RestBean<Void> saveCart(@RequestBody @Valid CartVo vo){
        return this.messageHandle(() ->
                cartService.saveCart(vo));
    }

    @PostMapping ("/updateCart")
    public RestBean<Void> updateCart(@RequestBody @Valid Cart cart){
        return this.messageHandle(() ->
                cartService.updateCart(cart));
    }

    @RequestMapping("/removeCart/{cartId}")
    public RestBean<Void> removeCart(@PathVariable Integer cartId){
        return this.messageHandle(() ->
                cartService.removeCart(cartId));
    }

    private <T> RestBean<T> messageHandle(Supplier<String> action){
        String message = action.get();
        if(message == null)
            return RestBean.success();
        else
            return RestBean.failure(400, message);
    }
}

