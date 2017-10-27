package com.wzu.oa.common.entity;

import javax.persistence.*;

@Table(name = "oa_role_permission_relative")
public class RolePermissionRelative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色主键
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限主键
     */
    @Column(name = "permission_id")
    private Integer permissionId;

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
     * 获取角色主键
     *
     * @return role_id - 角色主键
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色主键
     *
     * @param roleId 角色主键
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限主键
     *
     * @return permission_id - 权限主键
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限主键
     *
     * @param permissionId 权限主键
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}