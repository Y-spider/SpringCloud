package top.chopper.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;
/*
   @Author:ROBOT
   @DateTime:2025/3/13 22:46
   @Version:1.0.0
   @Description:
   */
@RestController
public class PayCircuitController {
    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable Integer id){
        if(id == -4) throw new RuntimeException("---------circuit id 不能为负数");
        if(id == 9999){
            try {
                System.out.println("start==>"+System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(5);
                System.out.println("end==>"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return "hello circuit !input id is "+id;
    }
    @GetMapping("/pay/bulkhead/{id}")
    public String mySemaphoreBulkhead(@PathVariable Integer id){
        if(id == -4) throw new RuntimeException("---------bulkhead id 不能为负数");
        if(id == 9999){
            try {
                System.out.println("start==>"+System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(5);
                System.out.println("end==>"+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return "hello semaphore(信号量) bulkhead !input id is "+id;
    }

    // resilience4j 中的限流器调用方法
    @GetMapping("/pay/ratelimter/{id}")
    public String myRatelimter(@PathVariable("id") Integer id){
        return "hello ,myRatelimter 欢迎来到 inputId:"+id+"\t" + IdUtil.fastSimpleUUID();
    }
}
