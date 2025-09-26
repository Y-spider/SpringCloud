package top.chopper;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
   @Author:ROBOT
   @DateTime:2025/9/26 14:41
   @Version:1.0.0
   @Description: 该模块用于整合 spring-cloud-alibaba + sentinel(哨兵)组件
   */
@SpringBootApplication
@EnableDiscoveryClient
public class Main8401 {
    public static void main(String[] args) {
        SpringApplication.run(Main8401.class,args);
    }

}