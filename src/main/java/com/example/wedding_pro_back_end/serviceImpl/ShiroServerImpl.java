package com.example.wedding_pro_back_end.serviceImpl;

import com.example.wedding_pro_back_end.bean.dto.Resources;
import com.example.wedding_pro_back_end.bean.dto.User;
import com.example.wedding_pro_back_end.mapper.ShiroMapper;
import com.example.wedding_pro_back_end.service.ShiroServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author yfj
 * @version 1.0
 * @date 2020/04/15 下午 02:43
 * @description:
 */
@Service
public class ShiroServerImpl implements ShiroServer {
    @Autowired
    private ShiroMapper shiroMapper;

    @Override
    public User login(String name, String u_Pwd) {
        System.out.println("**********密码"+u_Pwd+"********用户"+name);
        return shiroMapper.login(name,u_Pwd);
    }

    @Override
    public List<Resources> orders() {
        return shiroMapper.orders();
    }

    @Override
    public Set<String> seRoles(String userName) {
        return shiroMapper.seRoles(userName);
    }

    @Override
    public Set<String> quanxian(String userName) {
        return shiroMapper.quanxian(userName);
    }
}
