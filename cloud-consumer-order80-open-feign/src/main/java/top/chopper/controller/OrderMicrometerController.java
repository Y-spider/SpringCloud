package top.chopper.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.chopper.apis.PayFeignApi;

/*
   @Author:ROBOT
   @DateTime:2025/7/23 14:55
   @Version:1.0.0
   @Description:
   */
@Controller
public class OrderMicrometerController {
    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/feign/micrometer/{id}")
    public String myFeignRequest(@PathVariable("id") Integer id){
        return payFeignApi.myMicrometer(id);
    }
}
