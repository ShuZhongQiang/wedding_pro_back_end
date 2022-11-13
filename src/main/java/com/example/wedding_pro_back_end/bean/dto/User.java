package com.example.wedding_pro_back_end.bean.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Description:
 * @Author: 舒忠强
 * @Data: 2022/11/12 0:37
 */
@Data
@TableName("users")
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "u_id")
    public Integer uId;
    @TableField("u_name")
    public String uName;
    @TableField("u_pwd")
    public String uPwd;
}
