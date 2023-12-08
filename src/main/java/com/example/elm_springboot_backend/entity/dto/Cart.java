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
@TableName("cart")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Cart implements BaseData {
    @TableId(value = "cartId", type = IdType.AUTO)
    private Integer cartId;
    //食品编号
    @TableField("foodId")
    private Integer foodId;
    //所属商家编号
    @TableField("businessId")
    private Integer businessId;
    //所属用户编号
    @TableField("userId")
    private Integer userId;
    //同一类型食品的购买数量
    @TableField("quantity")
    private Integer quantity;


}
