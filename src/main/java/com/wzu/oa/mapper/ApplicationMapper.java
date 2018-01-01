package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.Application;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface ApplicationMapper extends Mapper<Application> {

    List<Application> getMySubmitList(Integer userId);
}