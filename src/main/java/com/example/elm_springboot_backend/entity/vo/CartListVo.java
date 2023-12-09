package com.example.elm_springboot_backend.entity.vo;

import lombok.Data;

/**
 * 前端传以下值到后端，查询当前用户在当前商家下的购物车记录
 */
@Data
public class CartListVo {
    private Integer businessId;
    private Integer userId;
}
