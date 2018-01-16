package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.ApproveInfo;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface ApproveInfoMapper extends Mapper<ApproveInfo> {

    List<ApproveInfo> findListByApplicationId(Integer applicationId);
}