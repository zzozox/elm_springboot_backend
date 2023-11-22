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

@Data
@TableName("user")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements BaseData {
    //用户编号
    @TableId(value = "userId", type = IdType.ASSIGN_ID)
    private String userId;
    //用户密码
    private String password;
    //用户名程
    @TableField("userName")
    private String userName;
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
