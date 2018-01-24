package com.wzu.oa.controller;

import com.wzu.oa.service.ProcessDefinitionService;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author jack
 * @date 2017/12/18   13:09
 */
@Controller
public class ProcessDefinitionController {

    @Resource
    private ProcessDefinitionService processDefinitionService;


    /**
     * 跳转页面
     * @param page
     * @return
     */
    @RequestMapping("/FlowProcessDefinition/{page}")
    public String toPage(@PathVariable("page") String page) {
        return "/FlowProcessDefinition/" + page;
    }


    /**
     * 获取流程定义列表
     *
     * @return
     * @Param model
     */
    @RequiresPermissions("审批流程管理")
    @RequestMapping("/FlowProcessDefinition/list")
    public String flowProcessDefinitionList(Model model) {
        List<ProcessDefinition> processDefinitions = processDefinitionService.findLastList();
        model.addAttribute("processDefinitions", processDefinitions);
        return "/FlowProcessDefinition/list";
    }

    /**
     * 根据流程定义的key删除流程定义
     *
     * @param key
     * @return
     */
    @RequestMapping("/FlowProcessDefinition/deleteByKey")
    public String deleteByKey(String key) {
        processDefinitionService.deleteByKey(key);
        return "redirect:/FlowProcessDefinition/list";
    }


    /**
     * 部署流程定义
     * @param resource
     * @return
     */
    @RequestMapping(value = "/FlowProcessDefinition/deployProcessDefinition")
    public String deployProcessDefinition(MultipartFile resource) {
        processDefinitionService.deployProcessDefinition(resource);
        return "redirect:/FlowProcessDefinition/list";
    }


    /**
     * 查看流程图
     * @param pdId 流程定义id
     * @return
     */
    @RequestMapping(value = "/FlowProcessDefinition/showProcessImage")
    public void showProcessImage(String pdId, HttpServletResponse response) {
        InputStream inputStream = processDefinitionService.findPngInputStream(pdId);
       // 从程序中写出下载到客户端
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            // copy以及关闭流资源
            IOUtils.copy(inputStream, outputStream);
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
