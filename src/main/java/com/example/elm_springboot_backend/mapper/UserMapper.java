package com.example.elm_springboot_backend.mapper;

import com.example.elm_springboot_backend.entity.Account;
import com.example.elm_springboot_backend.entity.AccountUser;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@Mapper
public interface UserMapper {
    @Select("select * from db_account where username = #{text} or email = #{text}")
    Account findAccountByNameOrEmail(String text);

    @Select("select * from db_account where username = #{text} or email = #{text}")
    AccountUser findAccountUserByNameOrEmail(String text);

    @Insert("insert into db_account (email, username, password) values (#{email}, #{username}, #{password})")
    int createAccount(String username, String password, String email);

    @Update("update db_account set password = #{password} where email = #{email}")
    int resetPasswordByEmail(String password, String email);
}