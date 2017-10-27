package com.wzu.oa.service.impl;


import com.wzu.oa.common.entity.UserBase;
import com.wzu.oa.mapper.UserBaseMapper;
import com.wzu.oa.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jack
 * @date 2017/10/23   21:40
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserBaseMapper userBaseMapper;

    @Override
    public void addUser(UserBase user) {
        userBaseMapper.insert(user);
    }

    @Override
    public UserBase findUserByAccount(String account) {
        UserBase userBase = new UserBase();
        userBase.setAccount(account);
        return userBaseMapper.selectOne(userBase);
    }
}
