package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.Post;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface PostMapper extends Mapper<Post> {
}