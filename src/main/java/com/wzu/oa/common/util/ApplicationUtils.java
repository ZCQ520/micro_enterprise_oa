package com.wzu.oa.common.util;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.wzu.oa.common.entity.Application;
import com.wzu.oa.common.entity.Template;
import com.wzu.oa.common.entity.User;
import com.wzu.oa.common.entity.var.ApplicationVar;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jack
 * @date 2017/12/29   15:45
 */
public class ApplicationUtils {
    public static Application getApplication( MultipartFile resource,User user,Template template){
        String saveFile = OAFileUtils.saveFile(resource);
        Application application = new Application();
        application.setApplyDate(new Date());
        application.setTemplateId(template.getId());
        application.setUserId(user.getId());
        application.setDocFilePath(saveFile);
        application.setStatus(ApplicationVar.STATUS_APPROVING);
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(application.getApplyDate());
        String title = template.getName()+"_"+user.getName()+"_"+dateStr;
        application.setTitle(title);
        return application;
    }
}
