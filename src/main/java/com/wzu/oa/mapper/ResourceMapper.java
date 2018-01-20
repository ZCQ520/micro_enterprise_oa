package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.Resource;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface ResourceMapper extends Mapper<Resource> {
    /**
     * 根据用户id查看资源
     * @param userId
     * @return
     */
    List<Resource> getResourcesListByUserId(Integer userId);
}