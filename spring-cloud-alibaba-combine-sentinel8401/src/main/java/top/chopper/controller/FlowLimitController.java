package top.chopper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.chopper.service.FlowLimitService;

import java.util.UUID;

/*
   @Author:ROBOT
   @DateTime:2025/9/26 17:07
   @Version:1.0.0
   @Description: 服务流量监控控制器
   */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String handleTestA(){
        return "--------testA";
    }

    @GetMapping("/testB")
    public String handleTestB(){
        return "--------testB";
    }
    /**
     * 流量控制-链路模式
     * 当设置阈值达到时，对C链路进行限流，对D链路不进行限流
     * */
    @Autowired
    private FlowLimitService flowLimitService;
    @GetMapping("/testC")
    public String handleTestC(){
        flowLimitService.common();
        return "--------testC";
    }

    @GetMapping("/testD")
    public String handleTestD(){
        flowLimitService.common();
        return "--------testD";
    }

    /**
     * 流控效果-排队等待
     * */
    @GetMapping("/testE")
    public String handleTestE(){
        System.out.println(System.currentTimeMillis() + "       -testE,排队等待~~");
        return "--------testE";
    }

    /**
     * @param time 任务处理时间
     * @return 处理结果
     */
    @GetMapping("/testF")
    public String handleTestF(@RequestParam("time") Long time){
        try {
            Thread.sleep(time);
            return "-----testF" + UUID.randomUUID();
        } catch ( InterruptedException e ) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/testG")
    public String handleTestG(){
        try {
            int a  = 10/0;
        }catch ( Exception e ){
            throw new RuntimeException(e);
        }
        return "---------testG";
    }

}
