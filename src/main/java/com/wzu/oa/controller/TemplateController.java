package com.wzu.oa.controller;

import com.wzu.oa.common.entity.Template;
import com.wzu.oa.service.ProcessDefinitionService;
import com.wzu.oa.service.TemplateService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jack
 * @date 2017/12/19   15:25
 */
@Controller
public class TemplateController {

    @Resource
    private TemplateService templateService;

    @Resource
    private ProcessDefinitionService processDefinitionService;

    /**
     * 跳转保存模板界面
     * @param model
     * @return
     */
    @RequestMapping("/FlowFormTemplate/saveUI")
    public String toSaveUI(Model model){
        List<ProcessDefinition> processDefinitions = processDefinitionService.findLastList();
        model.addAttribute("processDefinitions",processDefinitions);
        return "/FlowFormTemplate/saveUI";
    }

    /**
     * 获取模板列表
     * @param model
     * @return
     */
    @RequestMapping("page/FlowFormTemplate/list")
    public String getTemplateList(Model model){
        List<Template> templates = templateService.findList();
        model.addAttribute("templates",templates);
        return "/FlowFormTemplate/list";
    }

    /**
     * 添加或修改模板
     * @return
     */
    @RequestMapping(value = "/FlowFormTemplate/saveOrUpdateTemplate",method = RequestMethod.POST)
    public String saveOrUpdateTemplate(Template template, MultipartFile file){

        return "redirect:/page/FlowFormTemplate/list";
    }

}
