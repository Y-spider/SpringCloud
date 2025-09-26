package top.chopper.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
   @Author:ROBOT
   @DateTime:2025/9/25 15:39
   @Version:1.0.0
   @Description:
   */
@RestController
@RequestMapping("/alibaba")
@RefreshScope // nacos配置中心配置动态刷新
public class CloudAlibabaTestController {
    @Value("${test.text}")
    private String testText;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hello/{id}")
    public String handleSayHello(@PathVariable("id") String id){
        return "hello nacos server~~~~ id="+ id + "serverPort=" +  serverPort  +"///==/// testText=" + testText;
    }
}
