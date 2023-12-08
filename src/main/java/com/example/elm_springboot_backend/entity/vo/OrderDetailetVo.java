package com.example.elm_springboot_backend.entity.vo;

import lombok.Data;

@Data
public class OrderDetailetVo {
    private Integer orderId;
    private Integer foodId;
    private Integer quantity;
}
