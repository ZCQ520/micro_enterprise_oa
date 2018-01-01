package com.wzu.oa.common.entity.DTO;

import com.wzu.oa.common.entity.Template;

/**
 * @author jack
 * @date 2017/12/27   15:47
 */
public class TemplateDTO {
    private Template template;

    private String processDefinitionName;

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public String getProcessDefinitionName() {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(String processDefinitionName) {
        this.processDefinitionName = processDefinitionName;
    }
}
