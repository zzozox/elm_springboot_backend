package com.example.elm_springboot_backend.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Orders implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单编号
     */
    @TableId(value = "orderId", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 用户编号
     */
    @TableField("userId")
    private String userId;

    /**
     * 商家编号
     */
    @TableField("businessId")
    private Integer businessId;

    /**
     * 订购日期
     */
    @TableField("orderDate")
    private String orderDate;

    /**
     * 订单总价
     */
    @TableField("orderTotal")
    private BigDecimal orderTotal;

    /**
     * 送货地址编号
     */
    @TableField("daId")
    private Integer daId;

    /**
     * 订单状态（0：未支付； 1：已支付）
     */
    @TableField("orderState")
    private Integer orderState;


}
