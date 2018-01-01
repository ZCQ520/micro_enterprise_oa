package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.Application;
import com.wzu.oa.mapper.ApplicationMapper;
import com.wzu.oa.service.FlowService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2017/12/23   14:36
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FlowServiceImpl implements FlowService {

    @Resource
    private ProcessEngine processEngine;

    @Resource
    private ApplicationMapper applicationMapper;

    @Override
    public void submit(Application application, String pdKey) {
        //保存一个申请实体
        applicationMapper.insert(application);
        //启动一个流程
        Map<String,Object> variable = new HashMap<>();
        variable.put("application",application);
        variable.put("applicationId",application.getId());
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(pdKey, variable);
        //办理申请任务
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskAssignee(application.getUserId()+"");
        Task task = taskQuery.processInstanceId(processInstance.getId()).singleResult();
        taskService.complete(task.getId());
    }

    @Override
    public List<Application> getMySubmitList(Integer userId) {
        return applicationMapper.getMySubmitList(userId);
    }
}
