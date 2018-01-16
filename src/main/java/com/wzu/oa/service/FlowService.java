package com.wzu.oa.service;

import com.wzu.oa.common.entity.Application;
import com.wzu.oa.common.entity.DTO.ApplicationDTO;
import com.wzu.oa.common.entity.DTO.TaskDTO;
import com.wzu.oa.common.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2017/12/23   14:35
 */
public interface FlowService {

    /**
     * 提交用户申请流程,并根据pdKey开启流程
     * @param application
     * @param pdKey
     */
    void submit(Application application, String pdKey);

    /**
     * 根据用户id查看用户申请列表
     * @param userId
     * @return
     */
    List<ApplicationDTO> getMySubmitList(Integer userId);

    /**
     * 根据条件查询用户申请列表
     * @param map
     * @return
     */
    List<ApplicationDTO> queryApplication(Map<String, Object> map);

    /**
     * 根据用户查询用户的待办任务
     * @param user
     * @return
     */
    List<TaskDTO> findMyTaskList(User user);

    /**
     * 根据任务id查询任务信息
     * @param applicationId
     * @return
     */
    Application getApplicationById(Integer applicationId);


}
