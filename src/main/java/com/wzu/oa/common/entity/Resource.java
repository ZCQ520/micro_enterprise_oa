package com.wzu.oa.common.entity;

import javax.persistence.*;

@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父节点id
     */
    private Integer pid;

    /**
     * 资源名
     */
    private String name;

    /**
     * 是否为文件夹节点
     */
    @Column(name = "is_parent")
    private Boolean isParent;

    /**
     * 目标窗口
     */
    private String target;

    /**
     * 跳转路径
     */
    private String url;

    /**
     * 图标图片的路径
     */
    private String icon;

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
     * 获取父节点id
     *
     * @return pid - 父节点id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父节点id
     *
     * @param pid 父节点id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取资源名
     *
     * @return name - 资源名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置资源名
     *
     * @param name 资源名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取是否为文件夹节点
     *
     * @return is_parent - 是否为文件夹节点
     */
    public Boolean getIsParent() {
        return isParent;
    }

    /**
     * 设置是否为文件夹节点
     *
     * @param isParent 是否为文件夹节点
     */
    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    /**
     * 获取目标窗口
     *
     * @return target - 目标窗口
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置目标窗口
     *
     * @param target 目标窗口
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 获取跳转路径
     *
     * @return url - 跳转路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置跳转路径
     *
     * @param url 跳转路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取图标图片的路径
     *
     * @return icon - 图标图片的路径
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标图片的路径
     *
     * @param icon 图标图片的路径
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}