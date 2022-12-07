package com.xiaohe.shiro01demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class TestAuthentication {
    // shiro的配置文件支持 .ini格式, 使用复杂的数据格式
    // 现在使用配置文件主要是书写shiro的一些权限数据
    // 以后使用SpringBoot整合shiro时就不用了.
    @Test
    void contextLoads() {

        // 创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 从shiro配置文件中读取信息，放入realm
        Realm realm = new IniRealm("classpath:shiro.ini");
        // 给securityManager设置Realm
        securityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(securityManager);
        // 将安全管理器设置给安全工具类, 以后安全工具类就使用安全管理器中的信息.



        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken authenticationToken = new UsernamePasswordToken("xiaohe", "3456");
        // login没有返回值，认证成功继续向下走，认证失败报错: IncorrectCredentialsException
        try {
            subject.login(authenticationToken);
        } catch(IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("未认证");
        }
        System.out.println(subject.isAuthenticated());



    }

}
