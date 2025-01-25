package top.chopper.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.chopper.enmu.RetrunCodeEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/*
   @Author:ROBOT
   @DateTime:2025/1/25 16:07
   @Version:1.0.0
   @Description:
   */
@Data
@NoArgsConstructor
public class Result<T>{
    private static final Long serialVersionId = 1L;
    private String code;
    private String message;
    private T data;
    private long timestamp; // 时间戳

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = new Date().getTime();
    }


    // Static method to create success result
    public static <T> Result<T> SUCCESS(T data) {
        // Using the corrected enum name and getting code and message
        RetrunCodeEnum returnCodeEnum = Objects.requireNonNull(RetrunCodeEnum.getReturnEnumByCode("200"));
        return new Result<>(returnCodeEnum.getCode(), returnCodeEnum.getMessage(), data);
    }
    public static <T> Result<T> FAIL(T data,String code) {
        // Using the corrected enum name and getting code and message
        RetrunCodeEnum returnCodeEnum = Objects.requireNonNull(RetrunCodeEnum.getReturnEnumByCode(code));
        return new Result<>(returnCodeEnum.getCode(), returnCodeEnum.getMessage(), data);
    }
}
