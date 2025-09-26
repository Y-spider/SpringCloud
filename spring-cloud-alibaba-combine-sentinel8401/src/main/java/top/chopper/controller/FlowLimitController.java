package top.chopper.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
   @Author:ROBOT
   @DateTime:2025/9/26 17:07
   @Version:1.0.0
   @Description: 服务流量监控控制器
   */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String handleTestA(){
        return "--------testA";
    }

    @GetMapping("/testB")
    public String handleTestB(){
        return "--------testB";
    }

}
