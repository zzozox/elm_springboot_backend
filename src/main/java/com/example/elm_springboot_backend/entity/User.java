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
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户编号
     */
    @TableId(value = "userId", type = IdType.ASSIGN_ID)
    private String userId;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 用户性别（1：男； 0：女）
     */
    @TableField("userSex")
    private Integer userSex;

    /**
     * 用户头像
     */
    @TableField("userImg")
    private String userImg;

    /**
     * 删除标记（1：正常； 0：删除）
     */
    @TableField("delTag")
    private Integer delTag;


}
