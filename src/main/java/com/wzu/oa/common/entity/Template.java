package com.wzu.oa.common.entity;

import javax.persistence.*;

@Table(name = "template")
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 模板名称
     */
    private String name;

    /**
     * 流程定义key
     */
    @Column(name = "pd_key")
    private String pdKey;

    /**
     * 模板文件地址
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
     * 获取模板名称
     *
     * @return name - 模板名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置模板名称
     *
     * @param name 模板名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取流程定义key
     *
     * @return pd_key - 流程定义key
     */
    public String getPdKey() {
        return pdKey;
    }

    /**
     * 设置流程定义key
     *
     * @param pdKey 流程定义key
     */
    public void setPdKey(String pdKey) {
        this.pdKey = pdKey;
    }

    /**
     * 获取模板文件地址
     *
     * @return doc_file_path - 模板文件地址
     */
    public String getDocFilePath() {
        return docFilePath;
    }

    /**
     * 设置模板文件地址
     *
     * @param docFilePath 模板文件地址
     */
    public void setDocFilePath(String docFilePath) {
        this.docFilePath = docFilePath;
    }
}