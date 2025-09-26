package top.chopper.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
   @Author:ROBOT
   @DateTime:2025/9/25 11:25
   @Version:1.0.0
   @Description: spring cloud alibaba 服务处理器
   */
@RestController
@RequestMapping("/sca")
public class PaySpringCloudAlibabaController {
    @Value("${custom.name}")
    private String customName;

    @GetMapping("/name")
    public String getCustomName(){
        return "配置文件的自定义name=" + customName;
    }
}
