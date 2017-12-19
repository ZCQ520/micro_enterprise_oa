package com.wzu.oa.service;

import com.wzu.oa.common.entity.Template;

import java.util.List;

/**
 * @author jack
 * @date 2017/12/19   15:34
 */
public interface TemplateService {
    /**
     * 查询所有模板列表
     * @return
     */
    List<Template> findList();
}
