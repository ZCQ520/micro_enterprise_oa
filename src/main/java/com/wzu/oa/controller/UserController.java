package com.wzu.oa.controller;


import com.wzu.oa.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author jack
 * @date 2017/10/23   18:49
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    /**
     * 用户登陆
     * @return
     */
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/login")
    public String login(HttpServletRequest request, Model model) throws Exception {
        // 如果登录失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
        // 根据shiro返回的异常类路径判断，抛出指定异常信息
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if (exceptionClassName != null) {
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                model.addAttribute("msg","用户名不存在");
                return "/SystemUser/loginUI";
            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
                model.addAttribute("msg","用户名/密码不正确");
                return "/SystemUser/loginUI";
            }else {
                model.addAttribute("msg","未知错误");
                return "/SystemUser/loginUI";
            }
        }
        // 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
        // 登陆失败还到login页面
        return "/SystemUser/loginUI";

    }




    /**
     * 退出登陆
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/SystemUser/logout";
    }


}
