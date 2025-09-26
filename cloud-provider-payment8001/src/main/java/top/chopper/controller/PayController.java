package top.chopper.controller;

import cn.hutool.core.date.LocalDateTimeUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.chopper.entities.Pay;
import top.chopper.entities.Result;
import top.chopper.service.PayService;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        try {
            System.out.println("服务调用开始，开始时间:"+ LocalDateTimeUtil.now());
            TimeUnit.SECONDS.sleep(1);
            List<Pay> all = payService.getAll();
            System.out.println("服务调用完成，完成时间:"+ LocalDateTimeUtil.now());

            Result<List<Pay>> success = Result.SUCCESS(all);
            return success;
        } catch ( InterruptedException e ) {
            System.out.println("服务调用完成，完成时间:"+ LocalDateTimeUtil.now());
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/getInfo")
    public String getInfoByConsul(@Value("${test.info}")String info){
        return "获取到的远程配置信息为:\n"+info + "port:8001";
    }
}
