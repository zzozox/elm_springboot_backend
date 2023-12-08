package com.example.elm_springboot_backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.elm_springboot_backend.entity.dto.DeliveryAddress;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@Mapper
public interface DeliveryAddressMapper extends BaseMapper<DeliveryAddress> {
}
