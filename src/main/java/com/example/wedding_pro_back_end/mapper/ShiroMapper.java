package com.example.wedding_pro_back_end.mapper;

import com.example.wedding_pro_back_end.bean.dto.Resources;
import com.example.wedding_pro_back_end.bean.dto.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author yfj
 * @version 1.0
 * @date 2020/04/15 下午 02:40
 * @description:
 */
@Repository
public interface ShiroMapper {
    /**
     * 登陆
     * @param name 用户名
     * @param u_pwd 密码
     * @return
     */
    User login(@Param("name")String name, @Param("u_pwd")String u_pwd);

    /**
     * 查询资源
     * @return List
     */
    List<Resources> orders();

    /**
     * 根据用户查询角色
     * @param userName
     * @return
     */
    Set<String> seRoles(@Param("userName")String userName);

    /**
     * 根据名字查询权限
     * @param userName
     * @return
     */
    Set<String> quanxian(@Param("userName")String userName);
}
