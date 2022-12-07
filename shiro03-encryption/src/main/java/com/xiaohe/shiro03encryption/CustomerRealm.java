package com.xiaohe.shiro03encryption;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-07 11:34
 */
public class CustomerRealm extends AuthorizingRealm {
    // 使用hash匹配器验证密码是否正确
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1024);
        super.setCredentialsMatcher(matcher);
    }


    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户账号
        String principal = (String) token.getPrincipal();
        // 假设数据库中只有 xiaohe 一个用户
        String salt = "qwer";
        String username = "xiaohe";
        String password = "6a15c7bc4b85a5cd8109c842be10d631"; // 由123456哈希散列后的密码


        if (username.equals(principal)) {
            return new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), getName());
        }
        return null;

    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
