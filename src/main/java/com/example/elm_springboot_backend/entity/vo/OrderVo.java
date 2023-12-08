package com.example.elm_springboot_backend.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderVo {
    private Integer userId;
    private Integer businessId;
    private BigDecimal orderTotal;
    private Integer daId;
    private Integer orderState;
}
