package com.wzu.oa.service.impl;


import com.wzu.oa.common.entity.User;
import com.wzu.oa.common.util.MapUtils;
import com.wzu.oa.mapper.ResourceMapper;
import com.wzu.oa.mapper.UserMapper;
import com.wzu.oa.service.UserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2017/10/23   21:40
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ResourceMapper resourceMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return userMapper.selectOne(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<String> getUserPermissionsByResourceIds(List<Integer> resourceIds) {
        Map<String, Object> map = MapUtils.build().put("resourceIds", resourceIds).map();
        List<String> permissions = resourceMapper.getUserPermissionsByResourceIds(map);
        return permissions;
    }


}
