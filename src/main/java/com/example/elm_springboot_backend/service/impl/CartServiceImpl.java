package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.Cart;
import com.example.elm_springboot_backend.mapper.CartMapper;
import com.example.elm_springboot_backend.service.CartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
