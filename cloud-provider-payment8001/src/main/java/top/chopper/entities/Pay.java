package top.chopper.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 表名：t_pay
 * 表注释：支付交易表
 */
@Data
@TableName("t_pay")
public class Pay {

    /**
     * 主键ID，自增
     */
    @TableId(type = IdType.AUTO)
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

    /**
     * 删除标志，默认0不删除，1删除
     */
    private Byte deleted;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}
