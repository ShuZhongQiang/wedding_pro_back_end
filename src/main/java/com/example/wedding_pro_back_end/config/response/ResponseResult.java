package com.example.wedding_pro_back_end.config.response;

import com.example.wedding_pro_back_end.constant.ResponseStatus;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ResponseResult
 * @Description: 统一返回结果集定义
 * @Author: 舒忠强
 * @Data: 2022/11/9 14:15
 */

@Data
@Builder
public class ResponseResult<T> implements Serializable {

    /**
     * 响应时间戳
     */
    private long timestamp;

    /**
     * 响应状态码, 200 -> OK.
     */
    private String status;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应成功的结果包装器。
     *
     * @param <T> type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    /**
     * 响应成功的结果包装器。
     *
     * @param data response data
     * @param <T>  type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().data(data)
                .message(ResponseStatus.SUCCESS.getDescription())
                .status(ResponseStatus.SUCCESS.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * 响应错误结果包装器。
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> ResponseResult<T> fail(String message) {
        return fail(null, message);
    }

    /**
     * 响应错误结果包装器。
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> fail(T data, String message) {
        return ResponseResult.<T>builder().data(data)
                .message(message)
                .status(ResponseStatus.FAIL.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

}

