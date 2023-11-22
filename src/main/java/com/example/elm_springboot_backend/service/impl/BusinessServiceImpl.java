package com.example.elm_springboot_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.example.elm_springboot_backend.entity.dto.Business;
import com.example.elm_springboot_backend.mapper.BusinessMapper;
import com.example.elm_springboot_backend.service.BusinessService;
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
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

    @Resource
    private BusinessMapper businessMapper;
    /**
     * 获取全部商家列表
     * @return
     */
    @Override
    public List<Business> getAllBusinesses() {
        return list();
    }

    /**
     * mybatisPlus-QueryWrapper多条件查询
     * 根据商家类型编号查询某一类型商家信息
     * @param orderTypeId
     * @return
     */
    @Override
    public List<Business> listBusinessesByOrderTypeId(Integer orderTypeId) {
        QueryWrapper<Business> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("orderTypeId", orderTypeId);
        return businessMapper.selectList(queryWrapper);
    }

    /**
     * 根据商家Id查询商家信息
     * @param businessId
     * @return
     */
    @Override
    public Business getBusinessById(Integer businessId) {
        QueryWrapper<Business> foodQueryWrapper=new QueryWrapper<>();
        foodQueryWrapper.eq("businessId",businessId);
        return businessMapper.selectOne(foodQueryWrapper);
    }

}
