package top.chopper.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
   @Author:ROBOT
   @DateTime:2025/2/5 17:22
   @Version:1.0.0
   @Description:
   */
@Configuration
public class OpenFeignConfig {
    @Bean
    public Retryer retryer(){
        return Retryer.NEVER_RETRY; // 默认为不开启重试机制
        // 最大请求次数为3次 初始间隔时间为100ms 重试最大间隔时间为1s
//        return new Retryer.Default(100,1,3);
    }
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
