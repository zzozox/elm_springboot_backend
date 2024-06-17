package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.dto.Business;
import com.example.elm_springboot_backend.entity.dto.Orders;
import com.example.elm_springboot_backend.entity.vo.CartListVo;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetListVo;
import com.example.elm_springboot_backend.entity.vo.OrderDetailetVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderDetailetServiceImplTest {

    private OrderDetailetServiceImpl orderDetailetServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        orderDetailetServiceImplUnderTest = new OrderDetailetServiceImpl();
        ReflectionTestUtils.setField(orderDetailetServiceImplUnderTest, "cartMapper", null);
        ReflectionTestUtils.setField(orderDetailetServiceImplUnderTest, "foodMapper", null);
        ReflectionTestUtils.setField(orderDetailetServiceImplUnderTest, "foodService", null);
        ReflectionTestUtils.setField(orderDetailetServiceImplUnderTest, "ordersService", null);
        ReflectionTestUtils.setField(orderDetailetServiceImplUnderTest, "businessService", null);
        orderDetailetServiceImplUnderTest.orderDetailetMapper = null;
    }

    @Test
    void testListOrderDetailetbyUserId() {
        // Setup
        final OrderDetailetVo orderDetailetVo = new OrderDetailetVo();
        orderDetailetVo.setOrders(new Orders(0, 0, 0, "orderDate", new BigDecimal("0.00"), 0, 0));
        orderDetailetVo.setBusiness(
                new Business(0, "businessName", "businessAddress", "businessExplain", "businessImg", 0,
                        new BigDecimal("0.00"), new BigDecimal("0.00"), "remarks"));
        final OrderDetailetListVo orderDetailetListVo = new OrderDetailetListVo();
        orderDetailetListVo.setFoodId(0);
        orderDetailetListVo.setFoodName("foodName");
        orderDetailetListVo.setFoodImg("foodImg");
        orderDetailetListVo.setFoodPrice(new BigDecimal("0.00"));
        orderDetailetListVo.setQuantity(0);
        orderDetailetVo.setOrderDetailetListVos(List.of(orderDetailetListVo));
        final List<OrderDetailetVo> expectedResult = List.of(orderDetailetVo);

        // Run the test
        final List<OrderDetailetVo> result = orderDetailetServiceImplUnderTest.listOrderDetailetbyUserId(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testListOrderDetailet() {
        // Setup
        final CartListVo vo = new CartListVo();
        vo.setBusinessId(0);
        vo.setUserId(0);

        final OrderDetailetListVo orderDetailetListVo = new OrderDetailetListVo();
        orderDetailetListVo.setFoodId(0);
        orderDetailetListVo.setFoodName("foodName");
        orderDetailetListVo.setFoodImg("foodImg");
        orderDetailetListVo.setFoodPrice(new BigDecimal("0.00"));
        orderDetailetListVo.setQuantity(0);
        final List<OrderDetailetListVo> expectedResult = List.of(orderDetailetListVo);

        // Run the test
        final List<OrderDetailetListVo> result = orderDetailetServiceImplUnderTest.listOrderDetailet(vo);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
