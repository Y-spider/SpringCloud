package top.chopper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
   @Author:ROBOT
   @DateTime:2025/1/9 16:19
   @Version:1.0.0
   @Description:
   */
@SpringBootApplication
@MapperScan(value = "top.chopper.mapper")
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class,args);
    }
}
