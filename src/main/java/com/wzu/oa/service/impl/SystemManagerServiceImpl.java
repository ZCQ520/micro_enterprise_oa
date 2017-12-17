package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.DTO.UserDTO;
import com.wzu.oa.common.entity.Department;
import com.wzu.oa.common.entity.Post;
import com.wzu.oa.common.entity.DTO.SecondDepartment;
import com.wzu.oa.common.entity.User;
import com.wzu.oa.common.entity.UserPostRelative;
import com.wzu.oa.mapper.DepartmentMapper;
import com.wzu.oa.mapper.PostMapper;
import com.wzu.oa.mapper.UserMapper;
import com.wzu.oa.mapper.UserPostRelativeMapper;
import com.wzu.oa.service.SystemManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @date 2017/12/11   13:41
 */
@Service
public class SystemManagerServiceImpl implements SystemManagerService {

    @Resource
    private PostMapper postMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private UserPostRelativeMapper userPostRelativeMapper;

    @Override
    public List<Post> findAllPost() {
        List<Post> posts = postMapper.selectAll();
        return posts;
    }

    @Override
    public List<Department> getFirstDepartment() {
        List<Department> departments = departmentMapper.findFirstDept();
        return departments;
    }

    @Override
    public List<UserDTO> findAllUser() {
        List<User> users = userMapper.selectAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        if (users.size() != 0) {
            for (User user : users) {
                UserDTO userDTO = new UserDTO();
                userDTO.setUser(user);
                if (user.getDepartmentId() != null) {
                    Department department = departmentMapper.selectByPrimaryKey(user.getDepartmentId());
                    userDTO.setDepartmentName(department.getName());
                }
                userDTOS.add(userDTO);
            }
        }
        return userDTOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateRole(Post post) {
        boolean result = false;
        if (post.getId() == null) {
            if (postMapper.insert(post) == 1)
                result = true;
        } else {
            if (postMapper.updateByPrimaryKey(post) == 1)
                result = true;
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRole(Integer pid) {
        Post post = postMapper.selectByPrimaryKey(pid);
        if (post != null) {
            postMapper.delete(post);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Post getRoleById(Integer pid) {
        Post post = postMapper.selectByPrimaryKey(pid);
        return post;
    }

    @Override
    public List<SecondDepartment> findDepartmentListLevel2ByParentId(Integer did) {
        List<SecondDepartment> secondDepartments = departmentMapper.findDepartmentListLevel2ByParentId(did);
        return secondDepartments;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteDepartment(Integer did) throws Exception {
        Integer number = departmentMapper.deleteDepartment(did);
        if (number != 0)
            return true;
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateDepartment(Department department) {
        boolean result = false;
        if (department.getId() == null) {
            if (departmentMapper.insert(department) == 1)
                result = true;
        } else {
            if (departmentMapper.updateByPrimaryKey(department) == 1)
                result = true;
        }
        return result;
    }

    @Override
    public Department getDepartmentById(Integer did) {
        Department department = departmentMapper.selectByPrimaryKey(did);
        return department;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUserById(Integer uid) {
        userPostRelativeMapper.deleteByUserId(uid);
        int i = userMapper.deleteByPrimaryKey(uid);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<Department> findAllDepartment() {
        List<Department> departments = departmentMapper.selectAll();
        return departments;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateUser(User user, Integer[] roleIdList) {
        boolean result = saveOrUpdateUser(user);
        if (roleIdList != null && roleIdList.length > 0) {
            for (Integer roleId : roleIdList)
                userPostRelativeMapper.insert(new UserPostRelative(user.getId(), roleId));
        }
        return result;
    }

    @Override
    public boolean saveOrUpdateUser(User user) {
        boolean result = false;
        if (user.getId() == null) {
            if (userMapper.insert(user) == 1) {
                result = true;
            }

        } else {
            if (userMapper.updateByPrimaryKey(user) == 1) {
                userPostRelativeMapper.deleteByUserId(user.getId());
                result = true;
            }
        }
        return result;
    }

    @Override
    public User getUserById(Integer uid) {
        User user = userMapper.selectByPrimaryKey(uid);
        return user;
    }

    @Override
    public List<Post> getUserPostsByUserId(Integer uid) {
        List<UserPostRelative> userPostRelatives =  userPostRelativeMapper.getUserPostRelativeByUserId(uid);
        List<Post> posts = new ArrayList<>();
        if (userPostRelatives!=null&&userPostRelatives.size()>0){
            for (UserPostRelative userPostRelative: userPostRelatives){
                posts.add(postMapper.selectByPrimaryKey(userPostRelative.getPostid()));
            }
        }
        return posts;
    }
}

