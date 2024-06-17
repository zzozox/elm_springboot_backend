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

    /**
     * 根据商家编号查询该商家的食品
     * @param businessId
     * @return
     */
    @PostMapping ("/byBusinessId/{businessId}")
    public RestBean<List<Food>> FoodByBusinessId(@PathVariable Integer businessId) {
        List<Food> foods = foodService.listFoodByBusinessId(businessId);
        return RestBean.success(foods);
    }

    /**
     * 根据食品id查询食品信息
     * @param foodId
     * @return
     */
    @PostMapping("/byFoodId/{foodId}")
    public RestBean<Food> findFoodByFoodId(@PathVariable Integer foodId){
        return RestBean.success(foodService.getFoodById(foodId));
    }

}

