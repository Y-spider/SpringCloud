package top.chopper.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.chopper.apis.PayFeignApi;
import top.chopper.entities.Pay;
import top.chopper.entities.Result;

import java.util.Date;

/*
   @Author:ROBOT
   @DateTime:2025/8/7 23:54
   @Version:1.0.0
   @Description:
   */
@RestController
@RequestMapping("/feign/pay/gateway")
public class OrderGateWayController {
    @Autowired
    private PayFeignApi payFeignApi;

    @GetMapping("/get/{id}")
    public Result<Pay> getById(@PathVariable("id") Integer id){
        return payFeignApi.getByIdGateway(id);
    }

    @GetMapping("/getInfo/{info}")
    public String getInfo(@PathVariable("info") String info){
        return payFeignApi.getInfoByConsulGateWay();
    }

    @GetMapping("/filter")
    public String getGateWayFilter(){
        System.out.println("使用openfeign调用接口...");
        return payFeignApi.handleGateWayFilter();
    }

}
