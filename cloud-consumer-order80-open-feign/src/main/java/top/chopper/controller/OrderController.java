package top.chopper.controller;

import cn.hutool.core.date.LocalDateTimeUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.chopper.apis.PayFeignApi;
import top.chopper.entities.Pay;
import top.chopper.entities.Result;

import java.util.concurrent.TimeUnit;

/*
   @Author:ROBOT
   @DateTime:2025/1/25 17:09
   @Version:1.0.0
   @Description:
  */
@RestController
@RequestMapping("/feign")
public class OrderController {
    @Autowired
    private PayFeignApi payFeignApi;

    @PostMapping("/pay/add")
    public Result addOrder(@RequestBody Pay pay){
        return payFeignApi.addPay(pay);
    }

    @GetMapping("/pay/byId")
    public Result listById(@RequestParam("id") Integer id){
        return payFeignApi.getPayById(id);
    }

    @GetMapping("/pay/all")
    public Result listAll(){
        try {
            System.out.println("开始:"+LocalDateTimeUtil.now());
            return payFeignApi.getAll();
        }catch ( Exception e ){
            e.printStackTrace();
            System.out.println("结束:"+LocalDateTimeUtil.now());
        }
        return null;
    }

    @PutMapping("/pay")
    public Result update(@RequestBody Pay pay){
        return payFeignApi.updatePay(pay);
    }

    @GetMapping("/pay/delete")
    public Result delete(@RequestParam("id") Integer id){
        return payFeignApi.getPayById(id);
    }


}
