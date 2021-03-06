package com.wzu.oa.controller;


import com.wzu.oa.common.entity.DTO.TaskDTO;
import com.wzu.oa.common.entity.User;
import com.wzu.oa.service.FlowService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author jack
 * @date 2017/10/26   14:45
 */
@Controller
public class PageController {

    @Resource
    private FlowService flowService;

    @RequestMapping("/")
    public String toIndex(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        session.setAttribute("user",user);
        List<TaskDTO> taskDTOList = flowService.findMyTaskList(user);
        session.setAttribute("taskNumber",taskDTOList.size());
        return "index";
    }


    @RequestMapping("/index")
    public String toIndex2(HttpSession session){
        return toIndex(session);
    }

    @RequestMapping("/page/{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }

    @RequestMapping("/SystemUser/{page}")
    public String toSystemUserPage(@PathVariable("page") String page){
        return "/SystemUser/"+page;
    }


    @RequestMapping("/SystemRole/{page}")
    public String toSystemRolePage(@PathVariable("page") String page){
        return "/SystemRole/"+page;
    }

    @RequestMapping("/SystemDepartment/{page}")
    public String toSystemDepartmentPage(@PathVariable("page") String page){
        return "/SystemDepartment/"+page;
    }






}
