package com.wzu.oa.common.shiro;

import com.wzu.oa.common.entity.Permission;
import com.wzu.oa.common.entity.UserBase;
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
        String account = (String) token.getPrincipal();
        UserBase userBase = userService.findUserByAccount(account);
        String password = userBase.getPassword();
        return new SimpleAuthenticationInfo(userBase,password,getName());
    }
}
