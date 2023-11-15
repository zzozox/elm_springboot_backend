package com.example.elm_springboot_backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.elm_springboot_backend.entity.dto.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
