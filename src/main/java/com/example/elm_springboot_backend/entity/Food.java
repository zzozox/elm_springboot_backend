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
public class Food implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 食品编号
     */
    @TableId(value = "foodId", type = IdType.AUTO)
    private Integer foodId;

    /**
     * 食品名称
     */
    @TableField("foodName")
    private String foodName;

    /**
     * 食品介绍
     */
    @TableField("foodExplain")
    private String foodExplain;

    /**
     * 食品图片
     */
    @TableField("foodImg")
    private String foodImg;

    /**
     * 食品价格
     */
    @TableField("foodPrice")
    private BigDecimal foodPrice;

    /**
     * 所属商家编号
     */
    @TableField("businessId")
    private Integer businessId;

    /**
     * 备注
     */
    private String remarks;


}
