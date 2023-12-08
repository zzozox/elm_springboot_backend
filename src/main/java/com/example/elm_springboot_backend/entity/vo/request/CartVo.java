package com.example.elm_springboot_backend.entity.vo.request;

import lombok.Data;

@Data
public class CartVo {
    Integer foodId;
    Integer businessId;
    Integer userId;
    Integer quantity;
}
