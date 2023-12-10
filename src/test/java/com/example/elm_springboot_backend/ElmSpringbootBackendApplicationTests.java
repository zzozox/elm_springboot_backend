package com.example.elm_springboot_backend;

import com.example.elm_springboot_backend.entity.vo.DeliveryAddressVo;
import com.example.elm_springboot_backend.entity.vo.OrderVo;
import com.example.elm_springboot_backend.service.*;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ElmSpringbootBackendApplicationTests {

    @Resource
    AccountService accountService;

    @Resource
    BusinessService businessService;

    @Resource
    FoodService foodService;

    @Resource
    CartService cartService;

    @Resource
    DeliveryAddressService deliveryAddressService;

    @Resource
    OrdersService ordersService;

    @Resource
    OrderDetailetService orderDetailetService;

    @Test
    void contextLoads() {
    }

    /**
     * 测试account
     */
    @Test
    public void TestAccount(){
        System.out.println(accountService.findAccountByNameOrEmail("周芷璇"));
    }
    /**
     * 测试business的功能
     */
    @Test
    public void TestBusiness(){
        System.out.println(businessService.getAllBusinesses());
        System.out.println(businessService.getBusinessById(10002));
        System.out.println(businessService.listBusinessesByOrderTypeId(1));
    }
    /**
     * 测试food的功能
     */
    @Test
    public void TestFood(){
        System.out.println(foodService.listFoodByBusinessId(10001));
    }

    /**
     * 测试购物车的功能
     */
    @Test
    public void TestCart(){

        System.out.println(cartService.listCartByAccountId(4));
//        System.out.println(cartService.listCartByAccountIdAndBusinessId(cart));
//        System.out.println(cartService.listCartByAccountId(4));
    }

    /**
     * 测试地址的功能
     */
    @Test
    public void TestDeliveryAddress(){
//        System.out.println(deliveryAddressService.listDeliveryAddressByUserId(4));
//        System.out.println(deliveryAddressService.getDeliveryAddressById(1));
        DeliveryAddressVo vo=new DeliveryAddressVo();
        vo.setAddress("云南大学呈贡校区");
        vo.setContactName("zhouzhixuan");
        vo.setContactSex(0);
        vo.setContactTel("12345678");
        vo.setUserId(4);
        deliveryAddressService.saveDeliveryAddress(vo);
        System.out.println(deliveryAddressService.getDeliveryAddressById(4));
    }

    /**
     * 测试订单的功能
     */
    @Test
    public void TestOrders(){
        OrderVo orderVo=new OrderVo();
        orderVo.setUserId(4);
        orderVo.setBusinessId(10001);
        orderVo.setDaId(1);
        orderVo.setOrderTotal(BigDecimal.valueOf(34));
        System.out.println(ordersService.saveOrders(orderVo));
    }


    @Test
    public void TestOrderDetailetService(){
        orderDetailetService.listOrderDetailetbyUserId(4);
    }
}


