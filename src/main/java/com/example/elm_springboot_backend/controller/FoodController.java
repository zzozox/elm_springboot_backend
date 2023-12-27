package com.example.elm_springboot_backend.controller;


import com.example.elm_springboot_backend.entity.RestBean;
import com.example.elm_springboot_backend.entity.dto.Business;
import com.example.elm_springboot_backend.entity.dto.Food;
import com.example.elm_springboot_backend.service.FoodService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
/**
 * food相关Controller
 */
@RestController
@RequestMapping("/food")
public class FoodController {
    @Resource
    private FoodService foodService;

    @PostMapping ("/byBusinessId/{businessId}")
    public RestBean<List<Food>> FoodByBusinessId(@PathVariable Integer businessId) {
        List<Food> foods = foodService.listFoodByBusinessId(businessId);
        return RestBean.success(foods);
    }

    @PostMapping("/byFoodId/{foodId}")
    public RestBean<Food> findFoodByFoodId(@PathVariable Integer foodId){
        return RestBean.success(foodService.getFoodById(foodId));
    }

}

