package com.example.elm_springboot_backend.entity;

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
public class Deliveryaddress implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 送货地址编号
     */
    @TableId(value = "daId", type = IdType.AUTO)
    private Integer daId;

    /**
     * 联系人姓名
     */
    @TableField("contactName")
    private String contactName;

    /**
     * 联系人性别
     */
    @TableField("contactSex")
    private Integer contactSex;

    /**
     * 联系人电话
     */
    @TableField("contactTel")
    private String contactTel;

    /**
     * 送货地址
     */
    private String address;

    /**
     * 所属用户编号
     */
    @TableField("userId")
    private String userId;


}
