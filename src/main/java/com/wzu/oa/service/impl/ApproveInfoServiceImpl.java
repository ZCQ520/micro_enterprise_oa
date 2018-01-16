package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.Application;
import com.wzu.oa.common.entity.ApproveInfo;
import com.wzu.oa.common.entity.DTO.ApproveInfoDTO;
import com.wzu.oa.common.entity.User;
import com.wzu.oa.common.entity.var.ApplicationVar;
import com.wzu.oa.mapper.ApplicationMapper;
import com.wzu.oa.mapper.ApproveInfoMapper;
import com.wzu.oa.service.ApproveInfoService;
import com.wzu.oa.service.UserService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @date 2018-01-16   11:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ApproveInfoServiceImpl implements ApproveInfoService {

    @Resource
    private ApproveInfoMapper approveInfoMapper;

    @Resource
    private ApplicationMapper applicationMapper;

    @Resource
    private UserService userService;

    @Resource
    private ProcessEngine processEngine;

    @Override
    public List<ApproveInfoDTO> findListByApplicationId(Integer applicationId) {
        List<ApproveInfo> approveInfos = approveInfoMapper.findListByApplicationId(applicationId);
        List<ApproveInfoDTO> approveInfoDTOS = new ArrayList<>();
        for (ApproveInfo approveInfo:approveInfos) {
            User user = userService.getUserById(approveInfo.getUserId());
            ApproveInfoDTO approveInfoDTO = new ApproveInfoDTO(approveInfo,user);
            approveInfoDTOS.add(approveInfoDTO);
        }
        return approveInfoDTOS;
    }

    @Override
    public void approve(ApproveInfo approveInfo, String taskId) {
        Task task = processEngine.getTaskService().createTaskQuery().taskId(taskId).singleResult();
        //获得流程实例id
        String processInstanceId = task.getProcessInstanceId();
        //保存审批实体
        approveInfoMapper.insert(approveInfo);
        //办理当前任务
        processEngine.getTaskService().complete(taskId);

        Application application = applicationMapper.findById(approveInfo.getApplicationId());
        //查询当前流程实例是否存在
        ProcessInstance processInstance = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        if (approveInfo.getApproval()){
            //如果审批结果为通过
            if (processInstance==null){
                //如果当前为最后一个办理节点，则将申请状态改为通过
                application.setStatus(ApplicationVar.STATUS_APPROVED);
            }
        }else {
            //如果审批结果为不通过，将申请状态改为不通过
            application.setStatus(ApplicationVar.STATUS_UNAPPROVED);
            // 如果当前办理人不是最后一个节点，手动结束流程
            if (processInstance != null) {
                processEngine.getRuntimeService().deleteProcessInstance(
                        processInstanceId, ApplicationVar.STATUS_UNAPPROVED);
            }
        }
        applicationMapper.updateByPrimaryKey(application);
    }
}
