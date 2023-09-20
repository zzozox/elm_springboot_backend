package com.example.elm_springboot_backend.service.impl;

import com.example.elm_springboot_backend.entity.Business;
import com.example.elm_springboot_backend.mapper.BusinessMapper;
import com.example.elm_springboot_backend.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
