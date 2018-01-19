package com.wzu.oa.service;

import com.wzu.oa.common.entity.Version;

import java.util.List;

/**
 * @author jack
 * @date 2018-01-18   16:24
 */
public interface VersionService {
    /**
     * 根据Kynamic Id获取当前节点的所有版本数据
     * @param kid
     * @return
     */
    List<Version> getVersionsByKid(Integer kid);
}
