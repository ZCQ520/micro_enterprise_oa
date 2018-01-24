package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.UserResource;
import com.wzu.oa.mapper.UserResourceMapper;
import com.wzu.oa.service.UserResourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jack
 * @date 2018-01-24   15:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserResourceServiceImpl implements UserResourceService {

    @Resource
    private UserResourceMapper userResourceMapper;

    @Override
    public void savePrivilege(Integer uid, List<UserResource> userResource) throws Exception {
        //首先删除原来的权限
        int i = userResourceMapper.deletePrivilegeByUserId(uid);
        System.out.println("删除该用户" + i + "条权限");
        if (userResource!=null&&userResource.size()!=0){
            int count = userResourceMapper.insertBatch(userResource);
            System.out.println("插入该用户" + count + "条权限");
        }
    }

    @Override
    public List<UserResource> getUserResourceByUserId(Integer userId) {
        return userResourceMapper.getUserResourceByUserId(userId);
    }
}
