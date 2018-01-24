package com.wzu.oa.service;

import com.wzu.oa.common.entity.UserResource;

import java.util.List; /**
 * @author jack
 * @date 2018-01-24   15:54
 */
public interface UserResourceService {
    /**
     * 保存用户权限
     * @param uid
     * @param userResource
     */
    void savePrivilege(Integer uid, List<UserResource> userResource) throws Exception;

    /**
     * 根据用户id查询该用户所拥有的资源
     * @return
     * @param userId
     */
    List<UserResource> getUserResourceByUserId(Integer userId);
}
