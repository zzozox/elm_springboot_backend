package com.example.elm_springboot_backend.service;

import com.example.elm_springboot_backend.entity.dto.Food;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
public interface FoodService extends IService<Food> {
    List<Food> listFoodByBusinessId(Integer businessId);
    Food getFoodById(Integer foodId);
}
