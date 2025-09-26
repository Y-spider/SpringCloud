package top.chopper.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.chopper.apis.PayFeignApi;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CompletableFuture;

/*
   @Author:ROBOT
   @DateTime:2025/3/13 23:33
   @Version:1.0.0
   @Description:
   */
@RestController
public class OrderCircuitController {
    @Resource
    private PayFeignApi payFeignApi;


    // 这个是断路器
    @GetMapping("/feign/pay/circuit/{id}")
    // name 表示要调的微服务名称 fallbackMethod 表示请求失败的回调函数
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback")
    public String payCircuit(@PathVariable("id") Integer id) {
        return payFeignApi.myCircuit(id);
    }
    // 服务降级的兜底服务
    public String myCircuitFallback(Throwable t){
        return "myCircuitFallback,系统繁忙，请稍后再试-------/(T o T)/~~";
    }

    // 舱壁 隔离测试信号量从舱壁 SEMAPHORE
//    @GetMapping("/feign/pay/bulkhead/{id}")
//    // name 表示要调的微服务名称 fallbackMethod 表示请求失败的回调函数
//    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadFallback",type = Bulkhead.Type.SEMAPHORE)
//    public String patSemaphore(@PathVariable("id") Integer id) {
//        return payFeignApi.myBulkhead(id);
//    }

    public String myBulkheadFallback(Throwable t){
        return "（SemaphoreBulkhead）隔板超过最大数量限制，系统繁忙，请稍后再试------------------/(ToT)/~~";
    }

    // 舱壁 隔离测试线程池舱壁 THREAD-POOL
    @GetMapping("/feign/pay/bulkhead/{id}")
    // name 表示要调的微服务名称 fallbackMethod 表示请求失败的回调函数
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadFallbackOfThreadPoll",type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> patThreadPool(@PathVariable("id") Integer id) {
        System.out.println(Thread.currentThread().getName()+"\t"+"----------开始进入准备区");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"----------准备离开准备区");
        return CompletableFuture.supplyAsync(()->payFeignApi.myBulkhead(id)+"\t"+" Bulkhead.Type.THREADPOOL");
    }
    public CompletableFuture<String> myBulkheadFallbackOfThreadPoll(Throwable t){
        return CompletableFuture.supplyAsync(()->"（FixedThreadPoolBulkhead）线程数最大数量限制，系统繁忙，请稍后再试------------------/(ToT)/~~");
    }


    // 测试调用限流器限流方法
    @GetMapping("/feign/pay/ratelimter/{id}")
    @RateLimiter(name = "cloud-payment-service",fallbackMethod="myRatelimterFallback")
    public String myRatelimt(@PathVariable("id") Integer id){
        return payFeignApi.myRatelimt(id);
    }

    public String myRatelimterFallback(){
        return "已经达到流量上限，当前请求已经被拒绝....";
    }


}
