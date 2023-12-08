package com.example.elm_springboot_backend.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * 登录验证成功的用户信息响应
 */
@Data
public class AuthorizeVO {
    String username;
    String role;
    String token;
    Date expire;
}
