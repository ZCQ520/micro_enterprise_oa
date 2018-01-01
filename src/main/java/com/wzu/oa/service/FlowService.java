package com.wzu.oa.service;

import com.wzu.oa.common.entity.Application;

import java.util.List;

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
    List<Application> getMySubmitList(Integer userId);
}
