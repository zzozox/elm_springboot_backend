package com.example.elm_springboot_backend.mapper;

import com.example.elm_springboot_backend.entity.dto.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    public List<Cart> listCart(Cart cart);

    @Insert("insert into cart values(null,#{foodId},#{businessId},#{userId},1)")
    public int saveCart(Cart cart);

    @Update("update cart set quantity=#{quantity} where foodId=#{foodId} and businessId=# {businessId} and userId=#{userId}")
            public int updateCart(Cart cart);

    public int removeCart(Cart cart);
}
