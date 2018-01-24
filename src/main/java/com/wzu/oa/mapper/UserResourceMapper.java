package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.UserResource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface UserResourceMapper extends Mapper<UserResource> {
    /**
     * 根据用户id删除该用户所有权限
     * @param uid
     */
    int deletePrivilegeByUserId(Integer uid);

    /**
     * 批量插入用户资源数据
     * @param userResource
     * @return
     */
    int insertBatch(@Param("userResource") List<UserResource> userResource);


    /**
     * 根据用户id获取该用户所有资源
     * @param userId
     * @return
     */
    List<UserResource> getUserResourceByUserId(Integer userId);
}