package com.example.elm_springboot_backend.controller;
import com.example.elm_springboot_backend.entity.RestBean;
import com.example.elm_springboot_backend.entity.dto.Business;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.elm_springboot_backend.service.BusinessService;

import java.util.List;
import java.util.function.Supplier;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */

/**
 * Business相关Controller
 */
@RestController
@RequestMapping("/business")
@Tag(name = "business", description = "business相关Controller")
public class BusinessController {
    @Resource
    private BusinessService businessService;

    /**
     * 列出所有商家
     *
     */
    @GetMapping("/list")
    public RestBean<List<Business>> getAllBusinesses() {
        List<Business> businesses=businessService.getAllBusinesses();
        return RestBean.success(businesses);
    }

    /**
     * 根据商家类型id查找商家
     * @param orderTypeId
     * @return
     */
    @PostMapping("/byOrderTypeId/{orderTypeId}")
    public RestBean<List<Business>> findBusinessesByOrderTypeId(@PathVariable Integer orderTypeId) {
        List<Business> businesses = businessService.listBusinessesByOrderTypeId(orderTypeId);
        return RestBean.success(businesses);
    }

    /**
     * 在搜索框里输入商家id对商家信息进行查询
     * @param businessId
     * @return
     */
    @PostMapping("/byBusinessId/{businessId}")
    public RestBean<Business> findBusinessById(@PathVariable Integer businessId) {
        try {
            Business business = businessService.getBusinessById(businessId);
            if (business != null) {
                return RestBean.success(business);
            } else {
                return RestBean.failure(400,"无该商家");
            }
        } catch (Exception e) {
            return RestBean.failure(500, "服务器错误");
        }
    }
}


