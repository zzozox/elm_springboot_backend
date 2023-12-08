package com.example.elm_springboot_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.elm_springboot_backend.entity.dto.Food;
import com.example.elm_springboot_backend.mapper.FoodMapper;
import com.example.elm_springboot_backend.service.FoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {
    @Resource
    private FoodMapper foodMapper;

    /**
     * 根据商家id查询商家所属食物
     * @param businessId
     * @return
     */
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        QueryWrapper<Food> foodQueryWrapper=new QueryWrapper<>();
        foodQueryWrapper.eq("businessId",businessId);
        return foodMapper.selectList(foodQueryWrapper);
    }

    @Override
    public Food getFoodById(Integer foodId) {
        return foodMapper.selectById(foodId);
    }
}
