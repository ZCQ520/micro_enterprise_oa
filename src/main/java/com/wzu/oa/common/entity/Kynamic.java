package com.wzu.oa.common.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "kynamic")
public class Kynamic {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父目录id
     */
    private Integer pid;



    /**
     * 是否为父节点
     */
    @Column(name = "is_parent")
    private Boolean isParent;

    /**
     * 名称
     */
    private String name;



    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 上传文件路径
     */
    @Column(name = "doc_file_path")
    private String docFilePath;

    /**
     * 描述
     */
    private String description;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父目录id
     *
     * @return pid - 父目录id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父目录id
     *
     * @param pid 父目录id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }



    /**
     * 获取是否为父节点
     *
     * @return is_parent - 是否为父节点
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * 设置是否为父节点
     *
     * @param isParent 是否为父节点
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }



    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取上传文件路径
     *
     * @return doc_file_path - 上传文件路径
     */
    public String getDocFilePath() {
        return docFilePath;
    }

    /**
     * 设置上传文件路径
     *
     * @param docFilePath 上传文件路径
     */
    public void setDocFilePath(String docFilePath) {
        this.docFilePath = docFilePath;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}