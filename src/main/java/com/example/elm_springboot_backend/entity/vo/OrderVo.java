package com.example.elm_springboot_backend.entity.vo;

import lombok.Data;

import java.math.BigDecimal;


/**
 * 前端传以下值到后端，进行saveOrder
 */
@Data
public class OrderVo {
    private Integer userId;
    private Integer businessId;
    private Integer daId;
    private BigDecimal orderTotal;
}
