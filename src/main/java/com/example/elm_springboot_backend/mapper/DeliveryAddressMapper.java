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
    @Select("select * from deliveryAddress where userId=#{userId} order by daId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId);

    @Select("select * from deliveryAddress where daId=#{daId}")
    public DeliveryAddress getDeliveryAddressById(Integer daId);

    @Insert("insert into deliveryAddress values(null,#{contactName},#{contactSex},# {contactTel},#{address},#{userId})")
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress);

    @Update("update deliveryAddress set contactName=#{contactName},contactSex=# {contactSex},contactTel=#{contactTel},address=#{address} where daId=#{daId}")
            public int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    @Delete("delete from deliveryAddress where daId=#{daId}")
    public int removeDeliveryAddress(Integer daId);

}
