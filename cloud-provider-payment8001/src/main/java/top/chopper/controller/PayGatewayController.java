package top.chopper.controller;

/*
   @Author:ROBOT
   @DateTime:2025/8/7 23:29
   @Version:1.0.0
   @Description:
   */

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.chopper.entities.Pay;
import top.chopper.entities.Result;
import top.chopper.service.PayService;

@RestController
@RequestMapping("/pay/gateway")
public class PayGatewayController {
    @Autowired
    private PayService service;

    @GetMapping("/get/{id}")
    public Result<Pay> getById(@PathVariable("id") Integer id){
        Pay pay = service.getById(id);
        return Result.SUCCESS(pay);
    }

    @GetMapping("/getInfo")
    public String getInfoByConsul(@Value("${test.info}")String info){
        return "获取到的远程配置信息为:\n"+info + "port:8001";
    }

    @GetMapping("/filter/addRequestHeader")
    public String handleGatewayAddRequestHeader(HttpServletRequest request){
        String requestColor = request.getHeader("X-Request-Color");
        System.out.println("requestColor====>" + requestColor);
        return "requestColor====>" + requestColor;
    }
}
