package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.DTO.UserDTO;
import com.wzu.oa.common.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface UserMapper extends Mapper<User> {


}