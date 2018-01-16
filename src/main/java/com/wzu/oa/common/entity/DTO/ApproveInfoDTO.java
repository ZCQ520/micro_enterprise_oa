package com.wzu.oa.common.entity.DTO;

import com.wzu.oa.common.entity.ApproveInfo;
import com.wzu.oa.common.entity.User;

/**
 * @author jack
 * @date 2018-01-16   11:39
 */
public class ApproveInfoDTO {

    private ApproveInfo approveInfo;

    private User user;

    public ApproveInfoDTO() {
    }

    public ApproveInfoDTO(ApproveInfo approveInfo, User user) {
        this.approveInfo = approveInfo;
        this.user = user;
    }

    public ApproveInfo getApproveInfo() {
        return approveInfo;
    }

    public void setApproveInfo(ApproveInfo approveInfo) {
        this.approveInfo = approveInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
