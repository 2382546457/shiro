package com.xiaohe.shiro03encryption;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;


import java.util.UUID;

/**
 * 6a15c7bc4b85a5cd8109c842be10d631
 */
public class Encode {
    public static void main(String[] args) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(new CustomerRealm());
        SecurityUtils.setSecurityManager(securityManager);

        AuthenticationToken token = new UsernamePasswordToken("xiaohe", "123456");
        Subject subject = SecurityUtils.getSubject();


        subject.login(token);


    }
}
