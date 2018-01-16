package com.wzu.oa.service;

import com.wzu.oa.common.entity.ApproveInfo;
import com.wzu.oa.common.entity.DTO.ApproveInfoDTO;

import java.util.List;

/**
 * @author jack
 * @date 2018-01-16   11:26
 */
public interface ApproveInfoService {
    /**
     * 根据申请id查看所有流转记录
     * @param applicationId
     * @return
     */
    List<ApproveInfoDTO> findListByApplicationId(Integer applicationId);

    /**
     * 对任务审批
     * @param approveInfo
     * @param taskId
     */
    void approve(ApproveInfo approveInfo, String taskId);
}
