package com.xiaohe.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-07 10:27
 */
public class 测试自定义Realm {
    public static void main(String[] args) {
        // 创建安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 给安全管理器设置自定义Realm
        CustomerRealm realm = new CustomerRealm();
        securityManager.setRealm(realm);

        // 工具类使用安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        // 开始验证
        AuthenticationToken token = new UsernamePasswordToken("xiaohe", "123456");
        Subject subject = SecurityUtils.getSubject();
        // 如果实现了自定义Realm，没有实现方法，会报: UnknownAccountException
        subject.login(token);

    }
}
