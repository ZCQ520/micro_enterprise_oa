package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.Permission;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface PermissionMapper extends Mapper<Permission> {
}