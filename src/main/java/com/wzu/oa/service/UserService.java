package com.wzu.oa.service;


import com.wzu.oa.common.entity.User;

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
}
