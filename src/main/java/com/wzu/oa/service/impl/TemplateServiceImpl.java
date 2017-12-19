package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.Template;
import com.wzu.oa.mapper.TemplateMapper;
import com.wzu.oa.service.TemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jack
 * @date 2017/12/19   15:34
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private TemplateMapper templateMapper;

    @Override
    public List<Template> findList() {
        return templateMapper.selectAll();
    }
}
