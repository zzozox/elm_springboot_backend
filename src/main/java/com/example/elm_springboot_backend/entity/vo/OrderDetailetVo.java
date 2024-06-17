package com.example.elm_springboot_backend.entity.vo;

import com.example.elm_springboot_backend.entity.dto.Business;
import com.example.elm_springboot_backend.entity.dto.Orders;
import lombok.Data;
import org.springframework.core.annotation.Order;

import java.math.BigDecimal;
import java.util.List;

/**
 * saveOrderDetailet
 */
@Data
public class OrderDetailetVo{
    private Orders orders;
    private Business business;
    private List<OrderDetailetListVo> orderDetailetListVos;
}
