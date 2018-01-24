package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Component
public interface ResourceMapper extends Mapper<Resource> {

    /**
     * 根据资源id获取用户所有权限
     * @param map
     * @return
     */
    List<String> getUserPermissionsByResourceIds(Map<String, Object> map);
}