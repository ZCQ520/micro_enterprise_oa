package com.wzu.oa.common.shiro;

import com.wzu.oa.common.entity.User;
import com.wzu.oa.common.entity.UserResource;
import com.wzu.oa.common.util.ListUtils;
import com.wzu.oa.service.UserResourceService;
import com.wzu.oa.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @date 2017/10/26   15:57
 */
public class UserRealm extends AuthorizingRealm{


    @Resource
    private UserService userService;

    @Resource
    private UserResourceService userResourceService;

    @Override
    public String getName(){
        return "UserRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }


    /**
     * 授权方法
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("Principal 对象不能为空");
        }
        User user = (User) principals.fromRealm(getName()).iterator().next();
        //获取用户所有的资源
        List<UserResource> userResources = userResourceService.getUserResourceByUserId(user.getId());
        List<String> permissions = new ArrayList<>();
        if (userResources!=null && userResources.size()!=0){
            List<Integer> resourceIds =ListUtils.getListFieldToList(userResources, "resourceId");
            permissions = userService.getUserPermissionsByResourceIds(resourceIds);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 认证方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        if (username == null) {
            throw new AccountException("用户名不能为空");
        }
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
        String password = user.getPassword();
        return new SimpleAuthenticationInfo(user,password,getName());
    }
}
