package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.dto.Orders;
import com.example.elm_springboot_backend.entity.vo.OrderVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrdersServiceImplTest {

    private OrdersServiceImpl ordersServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        ordersServiceImplUnderTest = new OrdersServiceImpl();
        ReflectionTestUtils.setField(ordersServiceImplUnderTest, "ordersMapper", null);
        ReflectionTestUtils.setField(ordersServiceImplUnderTest, "cartMapper", null);
        ReflectionTestUtils.setField(ordersServiceImplUnderTest, "orderDetailetMapper", null);
    }

    @Test
    void testSaveOrders() {
        // Setup
        final OrderVo vo = new OrderVo();
        vo.setUserId(0);
        vo.setBusinessId(0);
        vo.setDaId(0);
        vo.setOrderTotal(new BigDecimal("0.00"));

        final Orders expectedResult = new Orders(0, 0, 0, "orderDate", new BigDecimal("0.00"), 0, 0);

        // Run the test
        final Orders result = ordersServiceImplUnderTest.saveOrders(vo);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetOrdersById() {
        // Setup
        final Orders expectedResult = new Orders(0, 0, 0, "orderDate", new BigDecimal("0.00"), 0, 0);

        // Run the test
        final Orders result = ordersServiceImplUnderTest.getOrdersById(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testListOrdersByUserId() {
        // Setup
        final List<Orders> expectedResult = List.of(new Orders(0, 0, 0, "orderDate", new BigDecimal("0.00"), 0, 0));

        // Run the test
        final List<Orders> result = ordersServiceImplUnderTest.listOrdersByUserId(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
