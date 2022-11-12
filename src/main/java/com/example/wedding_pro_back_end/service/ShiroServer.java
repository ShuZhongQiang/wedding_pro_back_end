package com.example.wedding_pro_back_end.service;

import com.example.wedding_pro_back_end.bean.dto.Resources;
import com.example.wedding_pro_back_end.bean.dto.User;


import java.util.List;
import java.util.Set;

/**
 * @author 舒忠强
 * @version 1.0
 * @date 2020/04/15 下午 02:42
 * @description:
 */
public interface ShiroServer {
    /**
     * 登陆
     * @return
     */
    User login(String name, String u_Pwd);

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
    Set<String> seRoles(String userName);

    /**
     * 根据名字查询权限
     * @param userName
     * @return
     */
    Set<String> quanxian(String userName);
}
