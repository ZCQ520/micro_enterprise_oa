package com.wzu.oa.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "approve_info")
public class ApproveInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 审批人
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 对应申请
     */
    @Column(name = "application_id")
    private Integer applicationId;

    /**
     * 审批日期
     */
    @Column(name = "approve_date")
    private Date approveDate;

    /**
     * 是否通过
     */
    private Boolean approval;

    /**
     * 审批意见
     */
    private String comment;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取审批人
     *
     * @return user_id - 审批人
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置审批人
     *
     * @param userId 审批人
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取对应申请
     *
     * @return application_id - 对应申请
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     * 设置对应申请
     *
     * @param applicationId 对应申请
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取审批日期
     *
     * @return approve_date - 审批日期
     */
    public Date getApproveDate() {
        return approveDate;
    }

    /**
     * 设置审批日期
     *
     * @param approveDate 审批日期
     */
    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    /**
     * 获取是否通过
     *
     * @return approval - 是否通过
     */
    public Boolean getApproval() {
        return approval;
    }

    /**
     * 设置是否通过
     *
     * @param approval 是否通过
     */
    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    /**
     * 获取审批意见
     *
     * @return comment - 审批意见
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置审批意见
     *
     * @param comment 审批意见
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}