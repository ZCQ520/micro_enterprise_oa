package com.wzu.oa.service;

import com.wzu.oa.common.entity.Kynamic;

import java.util.List;

/**
 * @author jack
 * @date 2018-01-16   17:11
 */
public interface KynamicService {
    /**
     * 获取所有知识列表
     * @return
     */
    List<Kynamic> getAllKynamic();


    /**
     * 保存kynamic数据返回插入的id
     * @param kynamic
     * @return
     */
    Integer saveKynamic(Kynamic kynamic);

    /**
     * 查看名称是否已经存在
     * @param name
     * @return
     */
    boolean isExsitName(String name);

    /**
     * 根据id删除kynamic
     * @param id
     */
    void deleteKynamicById(Integer id);


    /**
     * 根据kynamic数据的id获取其兄弟节点
     * @param id
     * @return
     */
    List<Kynamic> getSiblingNodes(Integer id);

    /**
     * 根据当前节点id获取父节点
     * @param id
     * @return
     */
    Kynamic getParentNode(Integer id);



    /**
     * 根据id更新name数据
     * @param id
     * @param name
     */
    void updateKynamic(Integer id, String name);
}
