package top.chopper;


/*
   @Author:ROBOT
   @DateTime:2025/9/25 15:22
   @Version:1.0.0
   @Description:
   */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication9001 {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.run(PaymentApplication9001.class,args);
    }
}