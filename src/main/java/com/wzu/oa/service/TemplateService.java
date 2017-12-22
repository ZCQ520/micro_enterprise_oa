package com.wzu.oa.service;

import com.wzu.oa.common.entity.Template;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 添加或更新模板
     * @param template
     * @param file
     */
    void saveOrUpdateTemplate(Template template, MultipartFile file);

    /**
     * 根据id删除模板
     * @param tid
     */
    void deleteTemplateById(Integer tid);

    /**
     * 根据id查找模板
     * @param tid
     * @return
     */
    Template findById(Integer tid);
}
