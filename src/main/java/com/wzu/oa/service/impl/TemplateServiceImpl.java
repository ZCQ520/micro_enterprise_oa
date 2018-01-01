package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.Template;
import com.wzu.oa.common.util.OAFileUtils;
import com.wzu.oa.mapper.TemplateMapper;
import com.wzu.oa.service.TemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
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

    @Override
    public void saveOrUpdateTemplate(Template template, MultipartFile file) {
        String docFilePath = template.getDocFilePath();
        if (docFilePath != null && !docFilePath.equals("")) {
            File existFile = new File(docFilePath);
            if (existFile.exists()) {
                existFile.delete();
            }
        }
        String targetPath = OAFileUtils.saveFile(file);
        template.setDocFilePath(targetPath);

        if (template.getId() != null) {
            templateMapper.updateByPrimaryKey(template);
        } else {
            templateMapper.insert(template);
        }
    }

    @Override
    public void deleteTemplateById(Integer tid) {
        Template template = templateMapper.selectByPrimaryKey(tid);
        String docFilePath = template.getDocFilePath();
        if (docFilePath != null && !docFilePath.equals("")) {
            File file = new File(docFilePath);
            if (file.exists()) {
                file.delete();
            }
        }
        templateMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public Template findById(Integer tid) {
        return templateMapper.selectByPrimaryKey(tid);
    }
}
