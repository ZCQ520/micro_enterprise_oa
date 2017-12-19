package com.wzu.oa.controller;

import com.wzu.oa.common.entity.Department;
import com.wzu.oa.common.entity.Post;
import com.wzu.oa.common.entity.User;
import com.wzu.oa.service.SystemManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author jack
 * @date 2017/12/15   16:18
 */
@Controller
public class PersonConfigController {

    @Resource
    private SystemManagerService systemManagerService;

    /**
     * 跳转修改密码界面
     * @param model
     * @return
     */
    @RequestMapping(value = "/page/PersonConfig/editPasswordUI")
    public String editPasswordUI(Model model) {
        return "/PersonConfig/editPasswordUI";
    }

    /**
     * 跳转编辑用户个人信息界面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/page/PersonConfig/editUserInfoUI")
    public String editUserInfoUI(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Department department = systemManagerService.getDepartmentById(user.getDepartmentId());
        List<Post> posts = systemManagerService.getUserPostsByUserId(user.getId());
        model.addAttribute("department",department);
        model.addAttribute("posts",posts);
        return "/PersonConfig/editUserInfoUI";
    }

    /**
     * 修改密码
     * @param model
     * @param session
     * @param oldPassword
     * @param password
     * @return
     */
    @RequestMapping(value = "/PersonConfig/updatePassword")
    public String updatePassword(Model model,HttpSession session,String oldPassword ,String password) {
        User user = (User) session.getAttribute("user");
        if (user.getPassword().equals(oldPassword)){
            user.setPassword(password);
            boolean result = systemManagerService.saveOrUpdateUser(user);
            if (result) {
                model.addAttribute("msg", "修改成功");
            } else {
                model.addAttribute("msg", "修改失败");
            }
        }else {
            model.addAttribute("msg","原密码错误");
        }
        return "/PersonConfig/editPasswordUI";
    }
}
