package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.dto.Cart;
import com.example.elm_springboot_backend.entity.vo.CartListVo;
import com.example.elm_springboot_backend.entity.vo.CartVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CartServiceImplTest {

    private CartServiceImpl cartServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        cartServiceImplUnderTest = new CartServiceImpl();
        cartServiceImplUnderTest.cartMapper = null;
    }

    @Test
    void testListCartByAccountId() {
        // Setup
        final List<Cart> expectedResult = List.of(new Cart(0, 0, 0, 0, 0));

        // Run the test
        final List<Cart> result = cartServiceImplUnderTest.listCartByAccountId(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testListCartByAccountIdAndBusinessId() {
        // Setup
        final CartListVo vo = new CartListVo();
        vo.setBusinessId(0);
        vo.setUserId(0);

        final List<Cart> expectedResult = List.of(new Cart(0, 0, 0, 0, 0));

        // Run the test
        final List<Cart> result = cartServiceImplUnderTest.listCartByAccountIdAndBusinessId(vo);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testSaveCart() {
        // Setup
        final CartVo vo = new CartVo();
        vo.setFoodId(0);
        vo.setBusinessId(0);
        vo.setUserId(0);
        vo.setQuantity(0);

        // Run the test
        final String result = cartServiceImplUnderTest.saveCart(vo);

        // Verify the results
        assertThat(result).isEqualTo("添加购物车失败");
    }

    @Test
    void testUpdateCart() {
        // Setup
        final Cart cart = new Cart(0, 0, 0, 0, 0);

        // Run the test
        final String result = cartServiceImplUnderTest.updateCart(cart);

        // Verify the results
        assertThat(result).isEqualTo("添加购物车失败");
    }

    @Test
    void testRemoveCart() {
        // Setup
        // Run the test
        final String result = cartServiceImplUnderTest.removeCart(0);

        // Verify the results
        assertThat(result).isEqualTo("删除购物车失败");
    }
}
