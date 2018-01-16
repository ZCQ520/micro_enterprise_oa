package com.wzu.oa.common.entity;

import javax.persistence.*;

@Table(name = "kynamic")
public class Kynamic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否为父节点
     */
    @Column(name = "is_parent")
    private Boolean isParent;

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
     * 获取父id
     *
     * @return pid - 父id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父id
     *
     * @param pid 父id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
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
}