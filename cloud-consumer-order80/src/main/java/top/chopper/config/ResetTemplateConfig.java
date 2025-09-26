package top.chopper.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
   @Author:ROBOT
   @DateTime:2025/1/25 17:08
   @Version:1.0.0
   @Description: restTemplateRestTemplate 是 Spring 提供的一个用于与 RESTful 服务交互的客户端工具类。
   它封装了 HTTP 请求，简化了与远程服务器进行通信的流程，能够方便地发送 HTTP 请求和接收 HTTP 响应。这里主要是用于在不同的微服务之间进行调用的。
   */
@Configuration
@LoadBalancerClient(value = "cloud-payment-service",configuration = CustomLoadBalancerConfiguration.class )
// 这里的value 名称一定要和consul中希望采用随机负载均衡的服务名称保持一致。
public class ResetTemplateConfig {
    @Bean
    @LoadBalanced // 启动负载均衡，这个时候才可以正常的通过cloud-consumer-order 进行访问到我们的支付微服务模块
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
