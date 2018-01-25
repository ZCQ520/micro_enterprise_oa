package com.wzu.oa.controller;

import com.wzu.oa.common.entity.DTO.UserDTO;
import com.wzu.oa.common.entity.Department;
import com.wzu.oa.common.entity.Post;
import com.wzu.oa.common.entity.DTO.SecondDepartment;
import com.wzu.oa.common.entity.User;
import com.wzu.oa.service.SystemManagerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jack
 * @date 2017/12/11   13:12
 */
@Controller
public class SystemManagerController {

    @Resource
    private SystemManagerService systemManagerService;

    /**
     * 查询所有岗位列表
     *
     * @param model
     * @return
     */
    @RequiresPermissions("岗位管理")
    @RequestMapping(value = "/SystemRole/list")
    public String systemRoleList(Model model) {
        List<Post> posts = systemManagerService.findAllPost();
        model.addAttribute("posts", posts);
        return "/SystemRole/list";
    }


    /**
     * 添加或修改岗位
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/SystemRole/addOrUpdateRole")
    public String addOrUpdateRole(Model model, Post post) {
        boolean result = systemManagerService.saveOrUpdateRole(post);
        if (result) {
            return "redirect:/SystemRole/list";
        } else {
            model.addAttribute("msg", "添加失败");
            return "SystemRole/saveUI";
        }
    }


    /**
     * 删除岗位u
     *
     * @param model
     * @param pid
     * @return
     */
    @RequestMapping("/SystemRole/deleteRole")
    public String deleteRole(Model model, Integer pid) {
        boolean result = systemManagerService.deleteRole(pid);
        if (result) {
            return "redirect:/SystemRole/list";
        } else {
            model.addAttribute("msg", "删除失败");
            return "forward:/SystemRole/list";
        }
    }

    /**
     * 查看修改岗位
     *
     * @param model
     * @param pid
     * @return
     */
    @RequestMapping("/SystemRole/checkUpdateRole")
    public String checkUpdateRole(Model model, Integer pid) {
        Post post = systemManagerService.getRoleById(pid);
        model.addAttribute("post", post);
        return "SystemRole/saveUI";
    }


    /**
     * 查询所有部门列表
     *
     * @param model
     * @return
     */
    @RequiresPermissions("部门管理")
    @RequestMapping(value = "/SystemDepartment/list")
    public String systemDepartmentList(Model model) {
        List<Department> departments = systemManagerService.getFirstDepartment();
        model.addAttribute("departments", departments);
        return "/SystemDepartment/list";
    }

    /**
     * 查询所有二级部门列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/SystemDepartment/listLevel2")
    public String systemDepartmentListLevel2(Model model, Integer did) {
        List<SecondDepartment> secondDepartments = systemManagerService.findDepartmentListLevel2ByParentId(did);
        model.addAttribute("departments", secondDepartments);
        model.addAttribute("parentId", did);
        return "/SystemDepartment/listLevel2";
    }


    /**
     * 删除部门
     *
     * @param model
     * @param did
     * @return
     */
    //TODO 关联外键删除失败
    @RequestMapping("/SystemDepartment/deleteDepartment")
    public String deleteDepartment(Model model, Integer did) {
        Integer parentId = null;
        try {
            Department department = systemManagerService.getDepartmentById(did);
            parentId = department.getParentId();
            systemManagerService.deleteDepartment(did);
        } catch (Exception e) {
            model.addAttribute("msg", "含有外键关联数据，删除失败");
        }
        if (parentId == null)
            return "forward:/SystemDepartment/list";
        else {
            return "forward:/SystemDepartment/listLevel2?did=" + parentId;
        }
    }


    /**
     * 添加一级部门
     *
     * @param model
     * @param department
     * @return
     */
    @RequestMapping("/SystemDepartment/saveOrUpdateDepartment")
    public String saveOrUpdateDepartment(Model model, Department department) {
        boolean result = systemManagerService.saveOrUpdateDepartment(department);
        Integer parentId = department.getParentId();
        if (parentId == null)
            return "redirect:/SystemDepartment/list";
        else {
            return "redirect:/SystemDepartment/listLevel2?did=" + parentId;
        }
    }

    /**
     * 把父id携带跳转添加页面
     *
     * @param did
     * @return
     */
    @RequestMapping("/SystemDepartment/toSecondDepartmentUI")
    public String toSecondDepartmentUI(Model model, Integer did) {
        model.addAttribute("parentId", did);
        return "forward:/SystemDepartment/saveUI";
    }

    /**
     * 跳转到修改列表
     *
     * @param model
     * @param did
     * @return
     */
    @RequestMapping("/SystemDepartment/toUpdateUI")
    public String toUpdateUI(Model model, Integer did) {
        Department department = systemManagerService.getDepartmentById(did);
        model.addAttribute("department", department);
        model.addAttribute("parentId", department.getParentId());
        return "forward:/SystemDepartment/saveUI";
    }


    /**
     * 查询所有用户列表
     *
     * @param model
     * @return
     */
    @RequiresPermissions("用户管理")
    @RequestMapping(value = "/SystemUser/list")
    public String systemUserList(Model model) {
        List<UserDTO> users = systemManagerService.findAllUser();
        model.addAttribute("users", users);
        return "/SystemUser/list";
    }

    /**
     * 根据用户删除用户
     * @param model
     * @param uid
     * @return
     */
    @RequestMapping(value = "/SystemUser/deleteUser")
    public String deleteUser(Model model, Integer uid) {
        boolean result = systemManagerService.deleteUserById(uid);
        if (!result)
            model.addAttribute("msg","删除失败");
        return "forward:/SystemUser/list";
    }

    /**
     * 跳转到添加用户界面
     * @return
     */
    @RequestMapping("/SystemUser/saveUI")
    public String toSystemUserSaveUI(Model model){
        List<Department> departments = systemManagerService.findAllDepartment();
        List<Post> posts = systemManagerService.findAllPost();
        model.addAttribute("departments",departments);
        model.addAttribute("posts",posts);
        return "/SystemUser/saveUI";
    }


    /**
     * 添加或修改用户
     * @param model
     * @return
     */
    @RequestMapping(value = "/SystemUser/saveOrUpdateUser")
    public String saveOrUpdateUser(Model model, User user,Integer[] roleIdList) {
        boolean result = systemManagerService.saveOrUpdateUser(user,roleIdList);
        if (result) {
            return "redirect:/SystemUser/list";
        } else {
            model.addAttribute("msg", "添加失败");
            return "SystemUser/saveUI";
        }
    }


    /**
     * 添加或修改用户
     * @param model
     * @return
     */
    @RequestMapping(value = "/SystemUser/toUpdateUserUI")
    public String toUpdateUserUI(Model model, Integer uid) {
        List<Department> departments = systemManagerService.findAllDepartment();
        List<Post> posts = systemManagerService.findAllPost();
        User user = systemManagerService.getUserById(uid);
        model.addAttribute("departments",departments);
        model.addAttribute("posts",posts);
        model.addAttribute("user",user);
        return "/SystemUser/saveUI";
    }

}


