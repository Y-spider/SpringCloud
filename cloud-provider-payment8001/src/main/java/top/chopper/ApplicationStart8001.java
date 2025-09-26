package top.chopper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/*
   @Author:ROBOT
   @DateTime:2025/1/9 16:19
   @Version:1.0.0
   @Description:
   */
@SpringBootApplication
@MapperScan(value = "top.chopper.mapper")
@EnableDiscoveryClient
@RefreshScope // 启动远程配置文件及时刷新
public class ApplicationStart8001 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart8001.class,args);
    }
}
