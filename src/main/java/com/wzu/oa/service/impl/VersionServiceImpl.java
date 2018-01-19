package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.Version;
import com.wzu.oa.mapper.VersionMapper;
import com.wzu.oa.service.VersionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jack
 * @date 2018-01-18   16:26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VersionServiceImpl implements VersionService {

    @Resource
    private VersionMapper versionMapper;


    @Override
    public List<Version> getVersionsByKid(Integer kid) {
        return versionMapper.getVersionsByKid(kid);
    }
}
