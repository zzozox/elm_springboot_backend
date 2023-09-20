package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.User;
import com.example.elm_springboot_backend.mapper.UserMapper;
import com.example.elm_springboot_backend.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}