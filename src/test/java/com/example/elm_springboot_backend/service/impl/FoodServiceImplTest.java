package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.dto.Food;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FoodServiceImplTest {

    private FoodServiceImpl foodServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        foodServiceImplUnderTest = new FoodServiceImpl();
        ReflectionTestUtils.setField(foodServiceImplUnderTest, "foodMapper", null);
    }

    @Test
    void testListFoodByBusinessId() {
        // Setup
        final List<Food> expectedResult = List.of(
                new Food(0, "foodName", "foodExplain", "foodImg", new BigDecimal("0.00"), 0, 0, "remarks"));

        // Run the test
        final List<Food> result = foodServiceImplUnderTest.listFoodByBusinessId(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetFoodById() {
        // Setup
        final Food expectedResult = new Food(0, "foodName", "foodExplain", "foodImg", new BigDecimal("0.00"), 0, 0,
                "remarks");

        // Run the test
        final Food result = foodServiceImplUnderTest.getFoodById(0);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
