package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.dto.DeliveryAddress;
import com.example.elm_springboot_backend.entity.vo.DeliveryAddressVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DeliveryAddressServiceImplTest {

    private DeliveryAddressServiceImpl deliveryAddressServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        deliveryAddressServiceImplUnderTest = new DeliveryAddressServiceImpl();
        ReflectionTestUtils.setField(deliveryAddressServiceImplUnderTest, "deliveryAddressMapper", null);
    }

    @Test
    void testListDeliveryAddressByUserId() {
        // Setup
        final List<DeliveryAddress> expectedResult = List.of(
                new DeliveryAddress(0, "contactName", 0, "contactTel", "address", 0));

        // Run the test
        final List<DeliveryAddress> result = deliveryAddressServiceImplUnderTest.listDeliveryAddressByUserId(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetDeliveryAddressById() {
        // Setup
        final DeliveryAddress expectedResult = new DeliveryAddress(0, "contactName", 0, "contactTel", "address", 0);

        // Run the test
        final DeliveryAddress result = deliveryAddressServiceImplUnderTest.getDeliveryAddressById(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testSaveDeliveryAddress() {
        // Setup
        final DeliveryAddressVo vo = new DeliveryAddressVo();
        vo.setContactName("contactName");
        vo.setContactSex(0);
        vo.setContactTel("contactTel");
        vo.setAddress("address");
        vo.setUserId(0);

        // Run the test
        final String result = deliveryAddressServiceImplUnderTest.saveDeliveryAddress(vo);

        // Verify the results
        assertThat(result).isEqualTo("保存地址失败");
    }

    @Test
    void testUpdateDeliveryAddress() {
        // Setup
        final DeliveryAddress deliveryAddress = new DeliveryAddress(0, "contactName", 0, "contactTel", "address", 0);

        // Run the test
        final String result = deliveryAddressServiceImplUnderTest.updateDeliveryAddress(deliveryAddress);

        // Verify the results
        assertThat(result).isEqualTo("保存地址失败");
    }

    @Test
    void testRemoveDeliveryAddress() {
        // Setup
        // Run the test
        final String result = deliveryAddressServiceImplUnderTest.removeDeliveryAddress(0);

        // Verify the results
        assertThat(result).isEqualTo("删除地址失败");
    }
}
