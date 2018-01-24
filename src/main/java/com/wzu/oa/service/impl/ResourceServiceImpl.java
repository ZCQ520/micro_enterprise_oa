package com.wzu.oa.service.impl;

import com.wzu.oa.mapper.ResourceMapper;
import com.wzu.oa.service.ResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jack
 * @date 2018-01-24   10:44
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl implements ResourceService {

    @Resource
    private ResourceMapper resourceMapper;


    @Override
    public void addResource(List<com.wzu.oa.common.entity.Resource> resources) {
        for (com.wzu.oa.common.entity.Resource resource:resources){
            resourceMapper.insert(resource);
        }
    }

    @Override
    public List<com.wzu.oa.common.entity.Resource> getAllMenu() {
        return resourceMapper.selectAll();
    }
}
