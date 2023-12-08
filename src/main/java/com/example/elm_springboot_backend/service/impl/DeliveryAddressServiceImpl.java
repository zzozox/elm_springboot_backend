package com.example.elm_springboot_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.elm_springboot_backend.entity.dto.DeliveryAddress;
import com.example.elm_springboot_backend.entity.vo.request.DeliveryAddressVo;
import com.example.elm_springboot_backend.mapper.DeliveryAddressMapper;
import com.example.elm_springboot_backend.service.DeliveryAddressService;
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
public class DeliveryAddressServiceImpl extends ServiceImpl<DeliveryAddressMapper, DeliveryAddress> implements DeliveryAddressService {

    @Resource
    private DeliveryAddressMapper deliveryAddressMapper;

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(Integer userId) {
        QueryWrapper<DeliveryAddress> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("userId",userId);
        return deliveryAddressMapper.selectList(queryWrapper);
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return deliveryAddressMapper.selectById(daId);
    }

    @Override
    public String saveDeliveryAddress(DeliveryAddressVo vo) {
        DeliveryAddress da=new DeliveryAddress(null,
                vo.getContactName(),
                vo.getContactSex(),
                vo.getContactTel(),
                vo.getAddress(),
                vo.getUserId());
        if (deliveryAddressMapper.insert(da)==1){
            return null;
        }else {
            return "保存地址失败";
        }
    }

    @Override
    public String updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        UpdateWrapper<DeliveryAddress> deliveryAddressUpdateWrapper=new UpdateWrapper<>();
        deliveryAddressUpdateWrapper.eq("daId",deliveryAddress.getDaId())
                .set("address", deliveryAddress.getAddress())
                .set("contactTel",deliveryAddress.getContactTel())
                .set("contactName",deliveryAddress.getContactName())
                .set("contactSex",deliveryAddress.getContactSex());
        int update=deliveryAddressMapper.update(null, deliveryAddressUpdateWrapper);
        if (update==1){
            return null;
        }else {
            return "保存地址失败";
        }
    }

    @Override
    public String removeDeliveryAddress(Integer daId) {
        if(deliveryAddressMapper.deleteById(daId)==1){
            return null;
        }else {
            return "删除地址失败";
        }
    }
}
