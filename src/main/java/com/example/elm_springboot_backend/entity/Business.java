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
public class Business implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商家编号
     */
    @TableId(value = "businessId", type = IdType.AUTO)
    private Integer businessId;

    /**
     * 商家名称
     */
    @TableField("businessName")
    private String businessName;

    /**
     * 商家地址
     */
    @TableField("businessAddress")
    private String businessAddress;

    /**
     * 商家介绍
     */
    @TableField("businessExplain")
    private String businessExplain;

    /**
     * 商家图片（base64）
     */
    @TableField("businessImg")
    private String businessImg;

    /**
     * 点餐分类
     */
    @TableField("orderTypeId")
    private Integer orderTypeId;

    /**
     * 起送费
     */
    @TableField("starPrice")
    private BigDecimal starPrice;

    /**
     * 配送费
     */
    @TableField("deliveryPrice")
    private BigDecimal deliveryPrice;

    /**
     * 备注
     */
    private String remarks;


}
