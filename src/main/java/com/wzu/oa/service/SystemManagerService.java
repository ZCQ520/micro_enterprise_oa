package com.wzu.oa.service;

import com.wzu.oa.common.entity.DTO.UserDTO;
import com.wzu.oa.common.entity.Department;
import com.wzu.oa.common.entity.Post;
import com.wzu.oa.common.entity.DTO.SecondDepartment;
import com.wzu.oa.common.entity.User;

import java.util.List;

/**
 * @author jack
 * @date 2017/12/11   13:41
 */
public interface SystemManagerService {

    /**
     * 查找所以岗位列表
     * @return
     */
    List<Post> findAllPost();

    /**
     * 查找所有一级部门列表
     * @return
     */
    List<Department> getFirstDepartment();

    /**
     * 查找所有用户
     * @return
     */
    List<UserDTO> findAllUser();

    /**
     * 添加或修改岗位
     * @param post
     * @return
     */
    boolean saveOrUpdateRole(Post post);

    /**
     * 根据岗位id删除岗位
     * @param pid
     * @return
     */
    boolean deleteRole(Integer pid);

    /**
     * 根据id查看岗位
     * @param pid
     * @return
     */
    Post getRoleById(Integer pid);

    /**
     * 根据一级部门id查询所有二级部门id
     * @param did
     * @return
     */
    List<SecondDepartment> findDepartmentListLevel2ByParentId(Integer did);

    /**
     * 根据部门id删除部门
     * @param did
     * @return
     */
    boolean deleteDepartment(Integer did) throws Exception;

    /**
     * 保存或更新部门信息
     * @param department
     * @return
     */
    boolean saveOrUpdateDepartment(Department department);

    /**
     * 根据部门id获取部门信息
     * @param did
     * @return
     */
    Department getDepartmentById(Integer did);

    /**
     * 根据用户id删除用户
     * @param uid
     * @return
     */
    boolean deleteUserById(Integer uid);

    /**
     * 获取所有部门列表，包括二级部门
     * @return
     */
    List<Department> findAllDepartment();

    /**
     * 添加或修改用户
     * @param user
     * @param roleIdList
     * @return
     */
    boolean saveOrUpdateUser(User user, Integer[] roleIdList);

    /**
     * 添加或修改用户
     * @param user
     * @return
     */
    boolean saveOrUpdateUser(User user);

    /**
     * 根据用户id获取用户信息
     * @param uid
     * @return
     */
    User getUserById(Integer uid);

    /**
     * 根据用户id获取该用户所有岗位信息
     * @param id
     * @return
     */
    List<Post> getUserPostsByUserId(Integer id);



}
