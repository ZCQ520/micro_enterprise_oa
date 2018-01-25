package com.wzu.oa.controller;

import com.wzu.oa.common.entity.Application;
import com.wzu.oa.common.entity.ApproveInfo;
import com.wzu.oa.common.entity.DTO.ApplicationDTO;
import com.wzu.oa.common.entity.DTO.ApproveInfoDTO;
import com.wzu.oa.common.entity.DTO.TaskDTO;
import com.wzu.oa.common.entity.Template;
import com.wzu.oa.common.entity.User;
import com.wzu.oa.common.util.ApplicationUtils;
import com.wzu.oa.service.ApproveInfoService;
import com.wzu.oa.service.FlowService;
import com.wzu.oa.service.TemplateService;
import org.apache.commons.io.FileUtils;
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
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private ApproveInfoService approveInfoService;


    /**
     * 查看所有的申请模板
     * @param model
     * @return
     */
    @RequiresPermissions("发起申请")
    @RequestMapping("/FlowFormFlow/formTemplateList")
    public String formTemplateList(Model model) {
        List<Template> templates = templateService.findList();
        model.addAttribute("templates", templates);
        return "/FlowFormFlow/formTemplateList";
    }


    /**
     * 根据模板id跳转提交申请页面
     *
     * @param model
     * @param templateId
     * @return
     */
    @RequestMapping("/FlowFormFlow/submitUI")
    public String submitUI(Model model, Integer templateId) {
        model.addAttribute("templateId", templateId);
        return "/FlowFormFlow/submitUI";
    }


    /**
     * 提交申请单
     *
     * @param session
     * @param templateId
     * @param resource
     * @return
     */
    @RequestMapping(value = "/FlowFormFlow/submitApplication", method = RequestMethod.POST)
    public String submitApplication(HttpSession session, Integer templateId, MultipartFile resource) {
        User user = (User) session.getAttribute("user");
        Template template = templateService.findById(templateId);
        Application application = ApplicationUtils.getApplication(resource, user, template);
        flowService.submit(application, template.getPdKey());
        return "forward:/FlowFormFlowOld/mySubmittedList";
    }


    /**
     * 查看我的提交列表
     * @param model
     * @param session
     * @return
     */
    @RequiresPermissions("查询状态")
    @RequestMapping("/FlowFormFlowOld/mySubmittedList")
    public String mySubmittedList(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<ApplicationDTO> applicationDTOS = flowService.getMySubmitList(user.getId());
        model.addAttribute("applicationDTOS", applicationDTOS);
        List<Template> templates = templateService.findList();
        model.addAttribute("templates", templates);

        return "/FlowFormFlowOld/mySubmittedList";
    }


    /**
     * 根据条件查询我的申请列表
     * @param model
     * @param session
     * @param templateId
     * @param status
     * @return
     */
    @RequestMapping(value = "/FlowFormFlowOld/queryApplication" ,method = RequestMethod.POST)
    public String queryApplication(Model model, HttpSession session, Integer templateId, String status) {
        Map<String,Object> map = new HashMap<>();
        map.put("template_id",templateId);
        map.put("status",status);
        User user = (User) session.getAttribute("user");
        map.put("user_id",user.getId());
        List<ApplicationDTO> applicationDTOS = flowService.queryApplication(map);
        model.addAttribute("applicationDTOS", applicationDTOS);
        List<Template> templates = templateService.findList();
        model.addAttribute("templates", templates);
        return "/FlowFormFlowOld/mySubmittedList";
    }

    /**
     * 我的待处理任务
     * @param model
     * @param session
     * @return
     */
    @RequiresPermissions("审批处理")
    @RequestMapping("/FlowFormFlow/myTaskList")
    public String myTaskList(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<TaskDTO> taskDTOList = flowService.findMyTaskList(user);
        model.addAttribute("tasks", taskDTOList);
        return "/FlowFormFlow/myTaskList";
    }


    /**
     * 跳转审批页面
     *
     * @param applicationId
     * @param model
     * @return
     */
    @RequestMapping("/FlowFormFlow/approveUI")
    public String approveUI(Integer applicationId, String taskId, Model model) {
        model.addAttribute("applicationId", applicationId);
        model.addAttribute("taskId", taskId);
        return "/FlowFormFlow/approveUI";
    }


    /**
     * 下载申请单
     *
     * @param applicationId
     * @param response
     * @return
     */
    @RequestMapping("/FlowFormFlow/download")
    public ResponseEntity<byte[]> download(Integer applicationId, HttpServletResponse response) {
        Application application = flowService.getApplicationById(applicationId);
        String docFilePath = application.getDocFilePath();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        if (docFilePath != null && !docFilePath.equals("")) {
            File file = new File(docFilePath);
            if (file.exists()) {
                String suffix = "";
                String[] strings = docFilePath.split("\\.");
                if (strings.length > 1)
                    suffix = strings[strings.length - 1];
                String fileName = application.getTitle() + "." + suffix;
                try {
                    fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
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
        return new ResponseEntity<byte[]>(headers, HttpStatus.OK);
    }


    /**
     * 根据申请id查看审批流转记录
     *
     * @param applicationId
     * @param model
     * @return
     */
    @RequestMapping("/FlowFormFlow/approvedHistory")
    public String approvedHistory(Integer applicationId, Model model) {
        List<ApproveInfoDTO> approveInfoDTOS = approveInfoService.findListByApplicationId(applicationId);
        model.addAttribute("approveInfoDTOS", approveInfoDTOS);
        return "/FlowFormFlow/approvedHistory";
    }


    /**
     * 审批
     *
     * @param applicationId
     * @param taskId
     * @param comment
     * @param approval
     * @param session
     * @return
     */
    @RequestMapping("/FlowFormFlow/approve")
    public String approve(Integer applicationId, String taskId, String comment, boolean approval, HttpSession session) {
        //包装审批实体
        ApproveInfo approveInfo = new ApproveInfo();
        approveInfo.setApplicationId(applicationId);
        approveInfo.setApproval(approval);
        approveInfo.setApproveDate(new Date());
        approveInfo.setComment(comment);
        User user = (User) session.getAttribute("user");
        approveInfo.setUserId(user.getId());
        //审批
        approveInfoService.approve(approveInfo, taskId);
        Integer taskNumber = (Integer) session.getAttribute("taskNumber");
        if (taskNumber>=1) {
            taskNumber -= 1;
        }
        session.setAttribute("taskNumber",taskNumber);
        return "forward:/FlowFormFlow/myTaskList";
    }


    @RequestMapping("/FlowFormFlow/showForm")
    public String showForm(Integer applicationId, Model model) {
        model.addAttribute("applicationId", applicationId);
        return "/FlowFormFlow/showForm";
    }
}
