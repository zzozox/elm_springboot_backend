package com.example.elm_springboot_backend.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.elm_springboot_backend.entity.BaseData;
import lombok.AllArgsConstructor;
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
@TableName("orderdetailet")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderDetailet implements BaseData {

    /**
     * 订单明细编号
     */
    @TableId(value = "odId", type = IdType.AUTO)
    private Integer odId;

    /**
     * 所属订单编号
     */
    @TableField("orderId")
    private Integer orderId;

    /**
     * 食品编号
     */
    @TableField("foodId")
    private Integer foodId;

    /**
     * 数量
     */
    private Integer quantity;


}
