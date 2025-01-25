package top.chopper.entities;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

/*
   @Author:ROBOT
   @DateTime:2025/1/9 16:32
   @Version:1.0.0
   @Description:
   */
@Data
public class PayDto implements Serializable {
    private static final long serialVersionID = 1L;
    private Integer id;

    /**
     * 支付流水号
     */
    private String payNo;

    /**
     * 订单流水号
     */
    private String orderNo;

    /**
     * 用户账号ID
     */
    private Integer userId;

    /**
     * 交易金额
     */
    private BigDecimal amount;
}
