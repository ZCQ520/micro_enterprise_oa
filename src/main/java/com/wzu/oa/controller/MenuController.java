package com.wzu.oa.controller;

import com.wzu.oa.service.ResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jack
 * @date 2018-01-24   11:42
 */
@Controller
public class MenuController {

    @Resource
    private ResourceService resourceService;


    /**
     * 获取左边菜单栏
     * @return
     */
    //TODO 如果页面上的路径不以/开头，则认为是相对路径，默认会自动加上上个页面请求的路径
    @ResponseBody
    @RequestMapping("/menuItem/getAllMenu")
    public List<com.wzu.oa.common.entity.Resource> getAllMenu(){
        List<com.wzu.oa.common.entity.Resource> resources = resourceService.getAllMenu();
        return resources;
    }


    /**
     * 获取设置权限菜单
     * @return
     */
    @ResponseBody
    @RequestMapping("/menuItem/getPrivilegeMenu")
    public List<com.wzu.oa.common.entity.Resource> getPrivilegeMenu(){
        List<com.wzu.oa.common.entity.Resource> resources = resourceService.getAllMenu();
        for (com.wzu.oa.common.entity.Resource resource: resources){
            resource.setUrl(null);
        }
        return resources;
    }

}
