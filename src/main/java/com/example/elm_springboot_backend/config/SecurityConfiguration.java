package com.example.elm_springboot_backend.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                //SpringSecurity6.1要求用lambda表达式
                //前后端分离，后端只传数据，不控制页面跳转
                //替换原来页面，防止跳转默认302重定向
                //开放权限
                .authorizeHttpRequests(conf->conf
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(conf->conf
                        //定义登录网址
                        .loginProcessingUrl("/api/auth/login")
                        //返回给前端json格式数据
                        //调用方法
                        .successHandler(this::onAuthenticationSuccess)
                        .failureHandler(this::onAuthenticationFailure)
                )
                .logout(conf->conf
                        //定义登出页面网址
                        .logoutUrl("/api/auth/logout")
                        //返回给前端json格式数据
                        //调用方法
                        .logoutSuccessHandler(this::onLogoutSuccess)
                )
                //配置csrf
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(conf->conf
                        .authenticationEntryPoint(this::onAuthenticationFailure)
                )
                .build();

    }
    //登录成功处理
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        //设置编码格式，防止出现乱码
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("Successfully login");
    }

    //登录失败处理
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        //设置编码格式，防止出现乱码
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(exception.getMessage());
    }

    //登出成功处理
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException {
        //设置编码格式，防止出现乱码
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("Successfully logout");
    }

}
