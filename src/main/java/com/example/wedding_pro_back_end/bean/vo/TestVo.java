package com.example.wedding_pro_back_end.bean.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName: Test
 * @Description:
 * @Author: 舒忠强
 * @Data: 2022/11/9 16:27
 */

@Data
@TableName("test_form")
public class TestVo {
    @TableId(value = "id")
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("sex")
    private String sex;
}
