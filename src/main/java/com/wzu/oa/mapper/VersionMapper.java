package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.Version;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface VersionMapper extends Mapper<Version> {
    /**
     * 根据Kynamic Id获取当前节点的所有版本数据
     * @param kid
     * @return
     */
    List<Version> getVersionsByKid(Integer kid);
}