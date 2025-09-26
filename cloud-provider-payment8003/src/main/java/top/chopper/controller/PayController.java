package top.chopper.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.chopper.entities.Pay;
import top.chopper.entities.Result;
import top.chopper.service.PayService;
import java.util.List;
/*
   @Author:ROBOT
   @DateTime:2025/1/9 16:37
   @Version:1.0.0
   @Description:
   */
@RestController
@Slf4j
@RequestMapping("/pay")
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping
    public Result<String> addPay(@RequestBody Pay pay){
        payService.add(pay);
        return Result.SUCCESS("新增成功");
    }

    @GetMapping
    public Result<String> deletePay(@RequestParam("id") Integer id){
        payService.delete(id);
        return Result.SUCCESS("删除成功");
    }


    @PutMapping
    public Result<String> updatePay(@RequestBody Pay pay){
        payService.update(pay);
        return Result.SUCCESS("修改成功");
    }

    @GetMapping("/byId")
    public Result<Pay> getPayById(Integer id){
        return Result.SUCCESS(payService.getById(id));
    }

    @GetMapping("/all")
    public Result getAll(){
        List<Pay> all = payService.getAll();
        Result<List<Pay>> success = Result.SUCCESS(all);
        return success;
    }

    @GetMapping("/getInfo")
    public String getInfoByConsul(@Value("${test.info}")String info){
        return "获取到的远程配置信息为:\n"+info+ "port:8003";
    }
}
