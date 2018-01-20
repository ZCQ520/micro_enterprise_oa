package com.wzu.oa.common.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "resource")
public class Resource implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * shiro权限
     */
    private String permission;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 访问url
     */
    private String url;

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
     * 获取shiro权限
     *
     * @return permission - shiro权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置shiro权限
     *
     * @param permission shiro权限
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取访问url
     *
     * @return url - 访问url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置访问url
     *
     * @param url 访问url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}