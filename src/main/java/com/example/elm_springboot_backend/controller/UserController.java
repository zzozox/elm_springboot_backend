package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.AccountUser;
import com.example.elm_springboot_backend.entity.RestBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public RestBean<AccountUser> me(@SessionAttribute("account") AccountUser user){
        return RestBean.success(user);
    }
}

