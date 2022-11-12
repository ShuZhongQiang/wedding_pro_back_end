package com.example.wedding_pro_back_end.controller;

import com.example.wedding_pro_back_end.service.ShiroServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author yfj
 * @version 1.0
 * @date 2020/04/15 下午 02:37
 * @description: 控制层
 */
@RequestMapping("/shiro")
@Controller
public class ControllerDemo {

    @Autowired
    private ShiroServer shiroServer;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    //被踢出后跳转的页面
    @RequestMapping("/kickout")
    public String kickout(){
        return "kickout";
    }

    @RequestMapping("/submitLogin")
    public String submitLogin(String username, String password, Model model) {
        //加密格式
        String hashAlgorithmName="MD5";
        //用户输入的密码
        String credentials =password;
        //盐值
        Object salt = ByteSource.Util.bytes (username) ;
        //加密次数
        int hashIterations = 1024;
        //加密
        Object result =new SimpleHash(hashAlgorithmName,credentials, salt, hashIterations);
        System.out.println(result);
        try {
            //使用shiro 编写认证操作
            UsernamePasswordToken token = new UsernamePasswordToken(username, String.valueOf(result));
            //拿到subject
            Subject subject = SecurityUtils.getSubject();
            // 执行登陆方法
            subject.login(token);
            // 执行到这里说明用户已登录成功
            return "redirect:/shiro/index";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }catch (UnknownAccountException e){  //如果有登陆失败就会跳入这里
            model.addAttribute("msg","用户名不存在");   //UnknownAccountException(用户不存在)
            return "login";
        }
    }
    @RequestMapping("/tianjia")
    public String tianjia(){
        return "user/tianjai";
    }
    @RequestMapping("/update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }
    @RequestMapping("/wuquan")
    public String wuquan(){
        return "yichang";
    }
}
