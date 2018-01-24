package com.wzu.oa.service;

import com.wzu.oa.common.entity.Resource;

import java.util.List; /**
 * @author jack
 * @date 2018-01-24   10:44
 */
public interface ResourceService {
    /**
     * 添加菜单资源
     * @param resources
     */
    void addResource(List<Resource> resources);

    /**
     * 获取所有菜单
     * @return
     */
    List<Resource> getAllMenu();
}
