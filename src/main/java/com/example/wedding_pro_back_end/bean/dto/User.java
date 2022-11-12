package com.example.wedding_pro_back_end.bean.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description:
 * @Author: 舒忠强
 * @Data: 2022/11/12 0:37
 */
@Data
public class User implements Serializable {
    public Integer u_id;
    public String u_name;
    public String u_pwd;
}
