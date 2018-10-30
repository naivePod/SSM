package com.lgs.shiro;

import com.lgs.pojo.User;
import com.lgs.service.IUserService;
import com.lgs.service.impl.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Set;


public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService iUserService;


    /**
     * 功能描述:用于权限管理
     * @param:
     * @return: 
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleNames = iUserService.findRoles(username);
        Set<String> permissions = iUserService.findPermissions(username);
        info.setRoles(roleNames);
        info.setStringPermissions(permissions);

        return info;
    }

    /**
     * 功能描述:首先执行这个登录验证
     * @param:
     * @return: 
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        User user = iUserService.findUser(username);
        if(user != null) {
            AuthenticationInfo  info = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), "a");
            return info;
        } else {
            return null;
        }

    }
}
