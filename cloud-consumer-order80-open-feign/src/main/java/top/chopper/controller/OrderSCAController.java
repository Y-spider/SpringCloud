package top.chopper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.chopper.apis.PayFeignApi;

/*
   @Author:ROBOT
   @DateTime:2025/9/25 11:31
   @Version:1.0.0
   @Description: spring cloud alibaba 服务请求接口
   */
@RestController
@RequestMapping("/feign/sca")
public class OrderSCAController {
    @Autowired
    private PayFeignApi payFeignApi;
    @GetMapping("/name")
    public String getName(){
        return payFeignApi.getName();
    }
}
