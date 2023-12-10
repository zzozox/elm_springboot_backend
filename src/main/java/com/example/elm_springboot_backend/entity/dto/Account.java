package com.example.elm_springboot_backend.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.elm_springboot_backend.entity.BaseData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 数据库中的用户信息
 */
@Data
@TableName("user")
@AllArgsConstructor
public class Account implements BaseData {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer userId;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("email")
    private String email;
    @TableField("role")
    private String role;
    @TableField("register_time")
    private Date registerTime;
    //用户性别
    @TableField("userSex")
    private Integer userSex;
    //用户头像
    @TableField("userImg")
    private String userImg;
    //删除标记（1：正常； 0：删除）
    @TableField("delTag")
    private Integer delTag;
}
