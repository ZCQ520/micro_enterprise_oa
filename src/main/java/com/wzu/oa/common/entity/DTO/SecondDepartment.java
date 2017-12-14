package com.wzu.oa.common.entity.DTO;

import com.wzu.oa.common.entity.Department;

/**
 * @author jack
 * @date 2017/12/12   14:23
 */
public class SecondDepartment extends Department {

    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
