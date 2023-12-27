package com.example.elm_springboot_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.elm_springboot_backend.entity.dto.Business;
import com.example.elm_springboot_backend.mapper.BusinessMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BusinessServiceImplTest {

    @Mock
    private BusinessMapper mockBusinessMapper;

    @InjectMocks
    private BusinessServiceImpl businessServiceImplUnderTest;

    @Test
    void testGetAllBusinesses() {
        // Setup
        final List<Business> expectedResult = List.of(
                new Business(0, "businessName", "businessAddress", "businessExplain", "businessImg", 0,
                        new BigDecimal("0.00"), new BigDecimal("0.00"), "remarks"));

        // Configure BusinessMapper.selectList(...).
        final List<Business> businesses = List.of(
                new Business(0, "businessName", "businessAddress", "businessExplain", "businessImg", 0,
                        new BigDecimal("0.00"), new BigDecimal("0.00"), "remarks"));
        when(mockBusinessMapper.selectList(any(Wrapper.class))).thenReturn(businesses);

        // Run the test
        final List<Business> result = businessServiceImplUnderTest.getAllBusinesses();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllBusinesses_BusinessMapperReturnsNoItems() {
        // Setup
        when(mockBusinessMapper.selectList(any(Wrapper.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<Business> result = businessServiceImplUnderTest.getAllBusinesses();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testListBusinessesByOrderTypeId() {
        // Setup
        final List<Business> expectedResult = List.of(
                new Business(0, "businessName", "businessAddress", "businessExplain", "businessImg", 0,
                        new BigDecimal("0.00"), new BigDecimal("0.00"), "remarks"));

        // Configure BusinessMapper.selectList(...).
        final List<Business> businesses = List.of(
                new Business(0, "businessName", "businessAddress", "businessExplain", "businessImg", 0,
                        new BigDecimal("0.00"), new BigDecimal("0.00"), "remarks"));
        when(mockBusinessMapper.selectList(any(QueryWrapper.class))).thenReturn(businesses);

        // Run the test
        final List<Business> result = businessServiceImplUnderTest.listBusinessesByOrderTypeId(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testListBusinessesByOrderTypeId_BusinessMapperReturnsNoItems() {
        // Setup
        when(mockBusinessMapper.selectList(any(QueryWrapper.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<Business> result = businessServiceImplUnderTest.listBusinessesByOrderTypeId(0);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetBusinessById() {
        // Setup
        final Business expectedResult = new Business(0, "businessName", "businessAddress", "businessExplain",
                "businessImg", 0, new BigDecimal("0.00"), new BigDecimal("0.00"), "remarks");

        // Configure BusinessMapper.selectById(...).
        final Business business = new Business(0, "businessName", "businessAddress", "businessExplain", "businessImg",
                0, new BigDecimal("0.00"), new BigDecimal("0.00"), "remarks");
        when(mockBusinessMapper.selectById(0)).thenReturn(business);

        // Run the test
        final Business result = businessServiceImplUnderTest.getBusinessById(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
