package com.wzu.oa.service;


import com.wzu.oa.common.entity.Resource;
import com.wzu.oa.common.entity.User;

import java.util.List;

/**
 * @author jack
 * @date 2017/10/23   21:39
 */
public interface UserService {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 根据用户账号查询用户
     * @param username
     * @return
     */
     User findUserByUsername(String username);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * 根据用户id查看用户资源
     * @param userId
     * @return
     */
    List<Resource> getResourcesListByUserId(Integer userId);
}
