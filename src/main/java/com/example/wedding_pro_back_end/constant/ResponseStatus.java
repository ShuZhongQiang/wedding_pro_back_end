package com.example.wedding_pro_back_end.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: ResponseStatus
 * @Description: 基础状态码
 * @Author: 舒忠强
 * @Data: 2022/11/9 14:02
 */
@Getter
@AllArgsConstructor
public enum ResponseStatus {

    SUCCESS("200", "操作成功"),
    FAIL("500", "操作失败"),

    HTTP_STATUS_200("200", "ok"),
    HTTP_STATUS_400("400", "请求错误"),
    HTTP_STATUS_401("401", "未认证"),
    HTTP_STATUS_403("403", "未授权"),
    HTTP_STATUS_500("500", "业务处理异常");

    public static final List<ResponseStatus> HTTP_STATUS_ALL = Collections.unmodifiableList(
            Arrays.asList(HTTP_STATUS_200, HTTP_STATUS_400, HTTP_STATUS_401, HTTP_STATUS_403, HTTP_STATUS_500
            ));

    /**
     * 返回代码
     */
    private final String responseCode;

    /**
     * 返回描述
     */
    private final String description;

}
