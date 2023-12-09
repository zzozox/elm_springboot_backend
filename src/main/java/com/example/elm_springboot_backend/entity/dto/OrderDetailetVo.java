package com.example.elm_springboot_backend.entity.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * saveOrderDetailet
 */
@Data
@TableName("business")
@AllArgsConstructor
public class OrderDetailetVo {
    private Integer orderId;
    //暂时还不会往数据库里面存List，就直接用orderDetailetListVo的属性
    //private List<OrderDetailetListVo> orderDetailetListVos;
    //然后在数据库新建一个表orderDetailetVo来存
    //本来这应该是一个前端的类，但是现在将暂时把它移到后端
    //后续如果有时间将学习这部分知识并将前后端分开
    private Integer foodId;
    private String foodName;
    private String foodImg;
    private BigDecimal foodPrice;
    private Integer quantity;
}
