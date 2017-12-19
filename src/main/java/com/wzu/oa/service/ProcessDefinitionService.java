package com.wzu.oa.service;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * @author jack
 * @date 2017/12/18   13:12
 */
public interface ProcessDefinitionService {
    /**
     * 获取最新的流程定义列表
     * @return
     */
    List<ProcessDefinition> findLastList();

    /**
     * 根据key删除流程定义
     * @param key
     */
    void deleteByKey(String key);

    /**
     * 根据zip文件部署流程定义
     * @param resource
     */
    void deployProcessDefinition(MultipartFile resource);

    /**
     * 根据流程定义id获取png图片输入流
     * @param pdId
     * @return
     */
    InputStream findPngInputStream(String pdId);
}
