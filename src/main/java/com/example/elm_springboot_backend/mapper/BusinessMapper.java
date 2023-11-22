package com.example.elm_springboot_backend.mapper;

import com.example.elm_springboot_backend.entity.dto.Business;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author root
 * @since 2023-09-21
 */
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {
}
