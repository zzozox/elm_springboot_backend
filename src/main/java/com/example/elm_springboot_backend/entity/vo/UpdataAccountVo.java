package com.example.elm_springboot_backend.entity.vo;

import lombok.Data;

@Data
public class UpdataAccountVo {
    private Integer userId;
    private String username;
    private Integer userSex;
    private String userImg;
    private String password;
}
