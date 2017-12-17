package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.UserPostRelative;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface UserPostRelativeMapper extends Mapper<UserPostRelative> {
    /**
     * 根据用户删除改用户的岗位关联
     */
    int deleteByUserId(Integer uid);

    /**
     * 根据用户id获取关联信息
     * @param uid
     * @return
     */
    List<UserPostRelative> getUserPostRelativeByUserId(Integer uid);
}