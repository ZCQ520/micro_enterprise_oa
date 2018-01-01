package com.wzu.oa.controller;

import com.wzu.oa.common.entity.Application;
import com.wzu.oa.common.entity.Template;
import com.wzu.oa.common.entity.User;
import com.wzu.oa.common.entity.var.ApplicationVar;
import com.wzu.oa.common.util.ApplicationUtils;
import com.wzu.oa.common.util.OAFileUtils;
import com.wzu.oa.service.FlowService;
import com.wzu.oa.service.TemplateService;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author jack
 * @date 2017/12/23   14:33
 */
@Controller
public class FlowController {

    @Resource
    private TemplateService templateService;

    @Resource
    private FlowService flowService;


    /**
     * 查看所有的申请模板
     * @param model
     * @return
     */
    @RequestMapping("/page/FlowFormFlow/formTemplateList")
    public String formTemplateList(Model model) {
        List<Template> templates = templateService.findList();
        model.addAttribute("templates", templates);
        return "/FlowFormFlow/formTemplateList";
    }


    /**
     * 根据模板id跳转提交申请页面
     * @param model
     * @param templateId
     * @return
     */
    @RequestMapping("/FlowFormFlow/submitUI")
    public String submitUI(Model model,Integer templateId ) {
        model.addAttribute("templateId", templateId);
        return "/FlowFormFlow/submitUI";
    }


    /**
     * 提交申请单
     * @param model
     * @param session
     * @param templateId
     * @param resource
     * @return
     */
    @RequestMapping(value = "/FlowFormFlow/submitApplication",method = RequestMethod.POST)
    public String submitApplication(Model model, HttpSession session, Integer templateId, MultipartFile resource) {
        User user = (User) session.getAttribute("user");
        Template template = templateService.findById(templateId);
        Application application = ApplicationUtils.getApplication(resource, user, template);
        flowService.submit(application,template.getPdKey());
        return "forward:/FlowFormFlowOld/mySubmittedList";
    }



    @RequestMapping("/page/FlowFormFlowOld/mySubmittedList")
    public String mySubmittedList(Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Application> applications = flowService.getMySubmitList(user.getId());
        model.addAttribute("applications", applications);
        List<Template> templates = templateService.findList();
        model.addAttribute("templates",templates);

        return "/FlowFormFlowOld/mySubmittedList";
    }



}
