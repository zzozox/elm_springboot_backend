package com.example.elm_springboot_backend.service;

import com.example.elm_springboot_backend.entity.dto.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.elm_springboot_backend.entity.vo.CartListVo;
import com.example.elm_springboot_backend.entity.vo.CartVo;

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
    List<Cart> listCartByAccountId(Integer userId);
    List<Cart> listCartByAccountIdAndBusinessId(CartListVo vo);
    String saveCart(CartVo vo);
    String updateCart(Cart cart);
    String removeCart(Integer cartId);
}
