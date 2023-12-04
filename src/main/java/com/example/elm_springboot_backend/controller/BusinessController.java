package com.example.elm_springboot_backend.controller;
import com.example.elm_springboot_backend.entity.RestBean;
import com.example.elm_springboot_backend.entity.dto.Business;
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

@RestController
@RequestMapping("/business")
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
    public ResponseEntity<RestBean<Business>> findBusinessById(@RequestParam Integer businessId) {
        try {
            Business business = businessService.getBusinessById(businessId);
            if (business != null) {
                return ResponseEntity.ok(RestBean.success(business));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(RestBean.failure(500, "服务器错误"));
        }
    }

    private <T> RestBean<T> messageHandle(Supplier<String> action){
        String message = action.get();
        if(message == null)
            return RestBean.success();
        else
            return RestBean.failure(400, message);
    }
}


