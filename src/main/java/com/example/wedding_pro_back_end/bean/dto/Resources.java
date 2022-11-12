package com.example.wedding_pro_back_end.bean.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 舒忠强
 * @Description: 资源
 * Serializable 要缓存的JavaBean必须实现Serializable接口，因为Spring会将对象先序列化再存入 Redis
 */
@Data
public class Resources implements Serializable {
    public Integer id;
    public String key;
    public  String val;
    public Integer order;
}
