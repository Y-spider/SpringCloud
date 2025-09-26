package top.chopper.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
   @Author:ROBOT
   @DateTime:2025/7/23 14:30
   @Version:1.0.0
   @Description:
   */
@RestController
public class PayMicrometerController {
    @GetMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id){
        return "hello 这是我的micrometer InputId" + id + "\t" + "服务返回===>" + IdUtil.simpleUUID();
    }
}
