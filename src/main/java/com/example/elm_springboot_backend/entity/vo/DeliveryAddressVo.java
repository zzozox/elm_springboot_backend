package com.example.elm_springboot_backend.entity.vo;

import lombok.Data;

/**
 * 新增收货地址
 */
@Data
public class DeliveryAddressVo {
    //联系人姓名
    private String contactName;
    //联系人性别
    private Integer contactSex;
    //联系人电话
    private String contactTel;
    // 送货地址
    private String address;
    //所属用户编号
    private Integer userId;
}
