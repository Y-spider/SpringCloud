package top.chopper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
   @Author:ROBOT
   @DateTime:2025/2/4 16:58
   @Version:1.0.0
   @Description:
   */
@SpringBootApplication
@EnableFeignClients // 表示开启OpenFeign功能并激活
@EnableDiscoveryClient // 开始服务注册功能并激活
public class OpenFeignApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication80.class,args);
    }
}
