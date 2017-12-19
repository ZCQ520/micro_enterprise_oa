package com.wzu.oa.service.impl;

import com.wzu.oa.service.ProcessDefinitionService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @author jack
 * @date 2017/12/18   13:12
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProcessDefinitionServiceImpl implements ProcessDefinitionService {

    @Resource
    private ProcessEngine processEngine;


    @Override
    public List<ProcessDefinition> findLastList() {
        ProcessDefinitionQuery definitionQuery = processEngine.getRepositoryService().createProcessDefinitionQuery();
        definitionQuery.orderByProcessDefinitionVersion().asc();
        List<ProcessDefinition> list = definitionQuery.list();
        Map<String,ProcessDefinition> map = new HashMap<>();
        for (ProcessDefinition processDefinition:list){
            map.put(processDefinition.getKey(),processDefinition);
        }
        return new ArrayList<>(map.values());
    }

    @Override
    public void deleteByKey(String key) {
        ProcessDefinitionQuery query = processEngine.getRepositoryService().createProcessDefinitionQuery();
        query.processDefinitionKey(key);
        List<ProcessDefinition> list = query.list();
        for (ProcessDefinition processDefinition:list) {
            processEngine.getRepositoryService().deleteDeployment(processDefinition.getDeploymentId());
        }
    }

    @Override
    public void deployProcessDefinition(MultipartFile resource) {
        DeploymentBuilder deploymentBuilder = processEngine.getRepositoryService().createDeployment();
        ZipInputStream zipInputStream = null;
        try {
            zipInputStream = new ZipInputStream(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        deploymentBuilder.addZipInputStream(zipInputStream).deploy();
    }

    @Override
    public InputStream findPngInputStream(String pdId) {
        return processEngine.getRepositoryService().getProcessDiagram(pdId);
    }
}
