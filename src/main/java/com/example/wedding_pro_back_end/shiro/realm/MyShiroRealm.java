package com.example.wedding_pro_back_end.shiro.realm;

import com.example.wedding_pro_back_end.bean.dto.User;
import com.example.wedding_pro_back_end.service.ShiroServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
/**
 * @ClassName: MyRealm
 * @Description: //TODO Shiro拦截器机制
 * @Author: 舒忠强
 * @Data: 2022/11/11 14:32
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
    @Autowired
    private ShiroServer shiroServer;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        String password = String.valueOf(token.getPassword());
        // 从数据库获取对应用户名密码的用户
        User userList = shiroServer.login(name,password);
        if (userList == null) { //用户名不存在
            return null; //  shiro底层会抛出UnKnoAccountException 异常
        }
        logger.info("---------------- Shiro 凭证认证成功 ----------------------");
        //判断密码
        /**
         * 第一个参数是否返回给controller里的login数据
         * 第二个参数是数据库的密码
         * 第三个参数是名字
         */
        return new SimpleAuthenticationInfo(userList,userList.getU_pwd(),"");

    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
        Object principal = principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (principal instanceof User) {
            User userLogin = (User) principal;
            //根据名字查询角色
            Set<String> roles = shiroServer.seRoles(userLogin.getU_name());
            authorizationInfo.addRoles(roles);
            //根据名字查询权限
            Set<String> permissions = shiroServer.quanxian(userLogin.getU_name());
            authorizationInfo.addStringPermissions(permissions);
        }
        logger.info("---- 获取到以下权限 ----");
        logger.info(authorizationInfo.getStringPermissions().toString());
        logger.info("---------------- Shiro 权限获取成功 ----------------------");
        return authorizationInfo;
    }
}


