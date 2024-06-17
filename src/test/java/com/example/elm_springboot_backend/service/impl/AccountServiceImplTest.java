package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.dto.Account;
import com.example.elm_springboot_backend.entity.vo.ConfirmResetVO;
import com.example.elm_springboot_backend.entity.vo.EmailRegisterVO;
import com.example.elm_springboot_backend.entity.vo.EmailResetVO;
import com.example.elm_springboot_backend.entity.vo.UpdataAccountVo;
import com.example.elm_springboot_backend.utils.FlowUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AccountServiceImplTest {
    private AccountServiceImpl accountServiceImplUnderTest;
    @BeforeEach
    void setUp() {
        accountServiceImplUnderTest = new AccountServiceImpl();
        accountServiceImplUnderTest.verifyLimit = 0;
        accountServiceImplUnderTest.rabbitTemplate = null;
        accountServiceImplUnderTest.stringRedisTemplate = new StringRedisTemplate(null);
        accountServiceImplUnderTest.passwordEncoder = null;
        accountServiceImplUnderTest.flow = new FlowUtils();
        accountServiceImplUnderTest.accountMapper = null;
    }
    @Test
    void testLoadUserByUsername() {
        // Setup
        // Run the test
        final UserDetails result = accountServiceImplUnderTest.loadUserByUsername("username");

        // Verify the results
    }
    @Test
    void testLoadUserByUsername_ThrowsUsernameNotFoundException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> accountServiceImplUnderTest.loadUserByUsername("username"))
                .isInstanceOf(UsernameNotFoundException.class);
    }
    @Test
    void testRegisterEmailVerifyCode() {
        // Setup
        // Run the test
        final String result = accountServiceImplUnderTest.registerEmailVerifyCode("type", "email", "address");

        // Verify the results
        assertThat(result).isEqualTo("请求频繁，请稍后再试");
    }
    @Test
    void testRegisterEmailAccount() {
        // Setup
        final EmailRegisterVO info = new EmailRegisterVO();
        info.setEmail("email");
        info.setCode("code");
        info.setUsername("username");
        info.setPassword("password");
        // Run the test
        final String result = accountServiceImplUnderTest.registerEmailAccount(info);
        // Verify the results
        assertThat(result).isEqualTo("内部错误，注册失败");
    }
    @Test
    void testResetEmailAccountPassword() {
        // Setup
        final EmailResetVO info = new EmailResetVO();
        info.setEmail("email");
        info.setCode("code");
        info.setPassword("password");
        // Run the test
        final String result = accountServiceImplUnderTest.resetEmailAccountPassword(info);
        // Verify the results
        assertThat(result).isEqualTo("请先获取验证码");
    }
    @Test
    void testResetConfirm() {
        // Setup
        final ConfirmResetVO info = new ConfirmResetVO("email", "code");
        // Run the test
        final String result = accountServiceImplUnderTest.resetConfirm(info);
        // Verify the results
        assertThat(result).isEqualTo("请先获取验证码");
    }
    @Test
    void testFindAccountByNameOrEmail() {
        // Setup
        final Account expectedResult = new Account(0, "username", "password", "email", "user",
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), 0, "userImg", 0);
        // Run the test
        final Account result = accountServiceImplUnderTest.findAccountByNameOrEmail("text");
        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
    @Test
    void testFindAccountById() {
        // Setup
        final Account expectedResult = new Account(0, "username", "password", "email", "user",
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), 0, "userImg", 0);
        // Run the test
        final Account result = accountServiceImplUnderTest.findAccountById(0);
        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
    @Test
    void testUpdateAccount() {
        // Setup
        final UpdataAccountVo updataAccountVo = new UpdataAccountVo();
        updataAccountVo.setUserId(0);
        updataAccountVo.setUsername("username");
        updataAccountVo.setUserSex(0);
        updataAccountVo.setUserImg("userImg");
        updataAccountVo.setPassword("password");
        // Run the test
        final String result = accountServiceImplUnderTest.updateAccount(updataAccountVo);
        // Verify the results
        assertThat(result).isEqualTo("修改用户信息失败");
    }
}
