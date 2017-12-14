package com.wzu.oa.common.shiro;

import com.wzu.oa.common.entity.User;
import com.wzu.oa.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author jack
 * @date 2017/10/26   15:57
 */
public class UserRealm extends AuthorizingRealm{

    @Resource
    private UserService userService;

    @Override
    public String getName(){
        return "UserRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.findUserByUsername(username);
        String password = user.getPassword();
        return new SimpleAuthenticationInfo(user,password,getName());
    }
}
