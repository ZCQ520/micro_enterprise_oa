package com.wzu.oa.controller;

import com.wzu.oa.common.entity.DTO.TemplateDTO;
import com.wzu.oa.common.entity.Template;
import com.wzu.oa.common.util.OAFileUtils;
import com.wzu.oa.service.ProcessDefinitionService;
import com.wzu.oa.service.TemplateService;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
     *
     * @param model
     * @return
     */
    @RequestMapping("/FlowFormTemplate/saveUI")
    public String toSaveUI(Model model, Integer tid) {
        if (tid != null) {
            Template template = templateService.findById(tid);
            model.addAttribute("template", template);
        }
        List<ProcessDefinition> processDefinitions = processDefinitionService.findLastList();
        model.addAttribute("processDefinitions", processDefinitions);
        return "/FlowFormTemplate/saveUI";
    }

    /**
     * 获取模板列表
     * @param model
     * @return
     */
    @RequiresPermissions("表单模板管理")
    @RequestMapping("/FlowFormTemplate/list")
    public String getTemplateList(Model model) {
        List<Template> templates = templateService.findList();
        List<TemplateDTO> templateDTOS = new ArrayList<>();
        for (Template template : templates) {
            ProcessDefinition processDefinition = processDefinitionService.findProcessDefinitionByKey(template.getPdKey());
            TemplateDTO templateDTO = new TemplateDTO();
            templateDTO.setTemplate(template);
            templateDTO.setProcessDefinitionName(processDefinition.getName());
            templateDTOS.add(templateDTO);
        }
        model.addAttribute("templateDTOS", templateDTOS);
        return "/FlowFormTemplate/list";
    }

    /**
     * 添加或修改模板
     *
     * @return
     */
    @RequestMapping(value = "/FlowFormTemplate/saveOrUpdateTemplate", method = RequestMethod.POST)
    public String saveOrUpdateTemplate(Template template, MultipartFile file) {

        templateService.saveOrUpdateTemplate(template, file);
        return "redirect:/FlowFormTemplate/list";
    }


    /**
     * 根据模板id删除模板
     *
     * @param tid
     * @return
     */
    @RequestMapping("/FlowFormTemplate/deleteTemplateById")
    public String deleteTemplateById(Integer tid) {
        templateService.deleteTemplateById(tid);
        return "redirect:/FlowFormTemplate/list";
    }


    /**
     * 下载模板
     * @param tid
     * @return
     */
    @RequestMapping("/FlowFormTemplate/download")
    public ResponseEntity<byte[]> download(Integer tid, HttpServletResponse response) {
        Template template = templateService.findById(tid);
        String docFilePath = template.getDocFilePath();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        if (docFilePath != null && !docFilePath.equals("")) {
            File file = new File(docFilePath);
            if (file.exists()) {
//                String fileName = docFilePath;
//                String[] strings = docFilePath.split("\\\\");
//                if (strings != null && strings.length > 1)
//                    fileName = strings[strings.length - 1];
                String suffix = "";
                String[] strings = docFilePath.split("\\.");
                if (strings.length>1)
                    suffix = strings[strings.length-1];
                String fileName = template.getName()+"."+suffix;
                try {
                    fileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                headers.setContentDispositionFormData("attachment", fileName);
                try {
                    return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                            headers, HttpStatus.OK);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       return new ResponseEntity<byte[]>(headers,HttpStatus.OK);
    }

}
