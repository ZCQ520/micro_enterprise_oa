package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.Application;
import com.wzu.oa.common.entity.DTO.ApplicationDTO;
import com.wzu.oa.common.entity.DTO.TaskDTO;
import com.wzu.oa.common.entity.User;
import com.wzu.oa.mapper.ApplicationMapper;
import com.wzu.oa.service.FlowService;
import com.wzu.oa.service.UserService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private UserService userService;

    @Override
    public void submit(Application application, String pdKey) {
        //保存一个申请实体
        applicationMapper.insert(application);
        //启动一个流程
        Map<String, Object> variable = new HashMap<>();
        variable.put("application", application);
        variable.put("applicationId", application.getId());
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(pdKey, variable);
        //办理申请任务
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskAssignee(application.getUserId() + "");
        Task task = taskQuery.processInstanceId(processInstance.getId()).singleResult();
        taskService.complete(task.getId());
    }

    @Override
    public List<ApplicationDTO> getMySubmitList(Integer userId) {
        List<Application> applications = applicationMapper.getMySubmitList(userId);
        List<ApplicationDTO> applicationDTOS = new ArrayList<>();
        for (Application application:applications){
            User user = userService.getUserById(application.getUserId());
            ApplicationDTO applicationDTO = new ApplicationDTO(application,user);
            applicationDTOS.add(applicationDTO);
        }
        return applicationDTOS;
    }

    @Override
    public List<ApplicationDTO> queryApplication(Map<String, Object> map) {
        List<Application> applications  = applicationMapper.queryApplication(map);
        List<ApplicationDTO> applicationDTOS = new ArrayList<>();
        for (Application application:applications){
            User user = userService.getUserById(application.getUserId());
            ApplicationDTO applicationDTO = new ApplicationDTO(application,user);
            applicationDTOS.add(applicationDTO);
        }
        return applicationDTOS;
    }

    //TODO 审批人字段待定
    @Override
    public List<TaskDTO> findMyTaskList(User user) {
        TaskService taskService = processEngine.getTaskService();
        TaskQuery taskQuery = taskService.createTaskQuery();
        taskQuery.taskAssignee(user.getUsername());
        taskQuery.orderByTaskCreateTime().desc();
        List<Task> list = taskQuery.list();
        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task : list) {
            Application application = (Application) taskService.getVariable(task.getId(), "application");
            User applyUser = userService.getUserById(application.getUserId());
            TaskDTO taskDTO = new TaskDTO(task,application,applyUser);
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

    @Override
    public Application getApplicationById(Integer applicationId) {
        return applicationMapper.findById(applicationId);
    }


}
