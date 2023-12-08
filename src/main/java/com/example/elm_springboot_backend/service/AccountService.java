package com.example.elm_springboot_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.elm_springboot_backend.entity.dto.Account;
import com.example.elm_springboot_backend.entity.vo.ConfirmResetVO;
import com.example.elm_springboot_backend.entity.vo.EmailRegisterVO;
import com.example.elm_springboot_backend.entity.vo.EmailResetVO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends IService<Account>, UserDetailsService {
    Account findAccountByNameOrEmail(String text);
    String registerEmailVerifyCode(String type, String email, String address);
    String registerEmailAccount(EmailRegisterVO info);
    String resetEmailAccountPassword(EmailResetVO info);
    String resetConfirm(ConfirmResetVO info);
    Account findAccountById(Integer userId);
}
