package top.chopper.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.chopper.entities.Pay;
import top.chopper.entities.PayDto;
import top.chopper.mapper.PayMapper;
import top.chopper.service.PayService;

import java.util.ArrayList;
import java.util.List;

/*
   @Author:ROBOT
   @DateTime:2025/1/9 16:37
   @Version:1.0.0
   @Description:
   */
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper,Pay> implements PayService {
    @Autowired
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insert(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteById(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateById(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectById(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectList(null);
    }
}
