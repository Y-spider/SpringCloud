package top.chopper.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
   @Author:ROBOT
   @DateTime:2025/9/28 16:55
   @Version:1.0.0
   @Description:
   */
@RestController
public class RateLimiterController {
    @GetMapping("/rateLimit/byResource")
    // 这里的value关联的值与方法名称无关，可以随意写，只是按照习惯将名称写成方法名称。
    // handleBlockHandler 这个是我们自定义的限流处理器
    // blockHandlerClass 指定兜底方法所在的类,但是记住，如果写了blockHandlerClass，那么处理方法必须为static，不写则可以是静态方法也可以是普通方法！！！！
    @SentinelResource(value = "byResource",blockHandler = "handleBlockHandler",blockHandlerClass = RateLimiterController.class ,fallback = "doActionFailHandler")
    public String byResource(){
        return "按照资源名称SentinelResource限流测试ok";
    }

    public static String handleBlockHandler(BlockException blockException){
        return "自定义限流处理返回内容~~~~~~~~~~~";
    }

    public String doActionFailHandler(){
        return "自定义熔断兜底处理~~~~~~~~";
    }
}
