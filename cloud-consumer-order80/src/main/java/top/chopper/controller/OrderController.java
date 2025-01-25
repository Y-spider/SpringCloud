package top.chopper.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.chopper.entities.Pay;
import top.chopper.entities.Result;

/*
   @Author:ROBOT
   @DateTime:2025/1/25 17:09
   @Version:1.0.0
   @Description:
   */
@RestController
@RequestMapping("/consumer")
public class OrderController {
    public static final String url = "http://127.0.0.1:8001";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/pay/add")
    public Result addOrder(@RequestBody Pay pay){
        return restTemplate.postForObject(url + "/pay", pay, Result.class);
    }

    @GetMapping("/pay/byId")
    public Result listById(@RequestParam("id") Integer id){
        return restTemplate.getForObject(url+"/pay/byId?id="+id, Result.class);
    }

    @GetMapping("/pay/all")
    public Result listAll(){
        return restTemplate.getForObject(url+"/pay/all", Result.class);
    }
    @PutMapping("/pay")
    public Result update(@RequestBody Pay pay){
        restTemplate.put(url+"/pay",pay);
        return Result.SUCCESS("修改成功");
    }

        @GetMapping("/pay/delete")
    public Result delete(@RequestParam("id") Integer id){
        return restTemplate.getForObject(url + "/pay?id=" + id, Result.class);
    }
}
