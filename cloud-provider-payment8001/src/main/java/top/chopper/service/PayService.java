package top.chopper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.chopper.entities.Pay;
import top.chopper.entities.PayDto;

import java.util.List;
/*
   @Author:ROBOT
   @DateTime:2025/1/9 16:36
   @Version:1.0.0
   @Description:
   */
public interface PayService extends IService<Pay> {
    int add(Pay pay);

    int delete(Integer id);

    int update(Pay pay);

    Pay getById(Integer id);

    List<Pay> getAll();
}
