package top.chopper.enmu;

import lombok.Getter;

import java.util.Arrays;

/*
   @Author:ROBOT
   @DateTime:2025/1/25 16:09
   @Version:1.0.0
   @Description:
   */
@Getter
public enum RetrunCodeEnum {
    // 1. 举值
    RC999("999","操作失败"),
    RC200("200","操作成功"),
    RC201("201","服务开启降级保护，请稍后再试！"),
    RC202("202","热点参数限流，请稍后再试!"),
    RC203("203","系统规则不满足，请稍后再试!"),
    RC204("204","授权规则不通过，请稍后再试!"),
    RC403("403","无访问权限，请联系管理员授予权限!");


    // 如何定义一个通用的枚举类,对于枚举编写：举值-构造-遍历

    // 构造方法
    private final String message;
    private final String code;
    RetrunCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // 传统遍历
    public static RetrunCodeEnum getReturnEnumByCode(String code){
        for (RetrunCodeEnum value : RetrunCodeEnum.values()) {
            if(value.getCode().equals(code)){
                return value;
            }
        }
        return null;
    }
    // Stream 遍历
    public static RetrunCodeEnum getReturnEnumByCodeStream(String code){
        return Arrays.stream(RetrunCodeEnum.values()).filter(x -> x.getCode().equals(code)).findFirst().orElse(null);
    }
}
