package com.wzu.oa.common.entity.DTO;

import com.wzu.oa.common.entity.User;

/**
 * @author jack
 * @date 2017/12/14   14:20
 */
public class UserDTO {
    private User user;
    private String departmentName;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
