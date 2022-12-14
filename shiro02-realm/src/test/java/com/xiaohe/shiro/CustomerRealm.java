package com.xiaohe.shiro;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class CustomerRealm extends AuthorizingRealm {


    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户名
        String principal = (String) token.getPrincipal();
        // 假如数据库中只有 xiaohe一个账号
        String username = "xiaohe";
        String password = "123456";
        if (username.equals(principal)) {
            return new SimpleAuthenticationInfo(username, password, this.getName());
        }

        return null;
    }
}
