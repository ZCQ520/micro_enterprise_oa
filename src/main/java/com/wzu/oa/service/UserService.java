package com.wzu.oa.service;


import com.wzu.oa.common.entity.UserBase;

/**
 * @author jack
 * @date 2017/10/23   21:39
 */
public interface UserService {

    void addUser(UserBase user);

    /**
     * 根据用户账号查询用户
     * @param account
     * @return
     */
     UserBase findUserByAccount(String account);
}
