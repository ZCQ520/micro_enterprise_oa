package com.wzu.oa.common.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jack
 */
@Table(name = "application")
public class Application implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 申请人
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 模板
     */
    @Column(name = "template_id")
    private Integer templateId;

    /**
     * 申请日期
     */
    @Column(name = "apply_date")
    private Date applyDate;

    /**
     * 申请状态
     */
    private String status;

    /**
     * doc文件路径
     */
    @Column(name = "doc_file_path")
    private String docFilePath;

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
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取申请人
     *
     * @return user_id - 申请人
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置申请人
     *
     * @param userId 申请人
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取模板
     *
     * @return template_id - 模板
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * 设置模板
     *
     * @param templateId 模板
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取申请日期
     *
     * @return apply_date - 申请日期
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置申请日期
     *
     * @param applyDate 申请日期
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 获取申请状态
     *
     * @return status - 申请状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置申请状态
     *
     * @param status 申请状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取doc文件路径
     *
     * @return doc_file_path - doc文件路径
     */
    public String getDocFilePath() {
        return docFilePath;
    }

    /**
     * 设置doc文件路径
     *
     * @param docFilePath doc文件路径
     */
    public void setDocFilePath(String docFilePath) {
        this.docFilePath = docFilePath;
    }
}