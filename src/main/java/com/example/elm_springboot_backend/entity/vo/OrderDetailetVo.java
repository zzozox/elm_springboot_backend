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
    //暂时还不会往数据库里面存List，就直接用orderDetailetListVo的属性
    //private List<OrderDetailetListVo> orderDetailetListVos;
    //然后在数据库新建一个表orderDetailetVo来存
    //本来这应该是一个前端的类，但是现在将暂时把它移到后端
    //后续如果有时间将学习这部分知识并将前后端分开
    //又移回前端了
    private Orders orders;
    private Business business;
//    private Integer orderId;
//    private Integer orderState;
//    private BigDecimal orderTotal;
//    private String businessName;
//    private BigDecimal deliveryPrice;
    private List<OrderDetailetListVo> orderDetailetListVos;
}
