package top.chopper.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/*
   @Author:ROBOT
   @DateTime:2025/9/28 11:21
   @Version:1.0.0
   @Description:
   */
@Service
public class FlowLimitService {
    @SentinelResource(value = "common")
    public void common(){
        System.out.println("--------------FlowLimitService come in");
    }
}
