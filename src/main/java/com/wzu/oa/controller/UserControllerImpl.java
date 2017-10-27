package com.wzu.oa.controller;


import com.wzu.oa.common.entity.UserBase;
import com.wzu.oa.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author jack
 * @date 2017/10/23   18:49
 */
@Controller
@RequestMapping("/user")
public class UserControllerImpl {

    @Resource
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(Model model, HttpSession session,String account, String password) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);//验证角色和权限
            UserBase userBase = (UserBase) subject.getPrincipal();
            session.setAttribute("username",userBase.getName());
        } catch (Exception ex) {
                model.addAttribute("error","未知错误");
            return "/System_User/loginUI";
        }
        return "/index";
    }


    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/System_User/logout";
    }

    @RequestMapping("/addUser")
    public String addUser() {
        UserBase user = new UserBase();
        userService.addUser(user);
        return null;
    }
}
