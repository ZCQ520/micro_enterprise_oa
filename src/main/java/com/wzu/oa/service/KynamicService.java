package com.wzu.oa.service;

import com.wzu.oa.common.entity.DTO.KynamicDTO;
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
     * 根据id删除kynamic
     * @param id
     */
    boolean deleteKynamicById(Integer id);



    /**
     * 根据id更新name数据
     * @param id
     * @param name
     */
    void updateKynamic(Integer id, String name);

    /**
     * 获取根目录下所有文件
     * @return
     */
    List<KynamicDTO> getRootKynamicList();

    /**
     * 获取当前节点下所有数据
     * @param pid
     * @return
     */
    List<KynamicDTO> getCurrentNodeList(Integer pid);

    /**
     * 根据id获取当前路径
     * @param id
     * @return
     */
    String getCurrentPathById(Integer id);

    /**
     * 根据id获取Kynamic
     * @param id
     * @return
     */
    Kynamic getKynamicById(Integer id);

    /**
     * 获取根节点
     * @return
     */
    Kynamic getRootKynamic();

    /**
     * 添加kynamic
     * @param kynamic
     */
    void addOrUpdateKynamic(Kynamic kynamic);

    /**
     * 更新文件类型的kynamic描述
     * @param kynamic
     */
    void updateFileKynamic(Kynamic kynamic);


    /**
     * 更新kynamic名称
     * @param kynamic
     */
    boolean updateKynamicName(Kynamic kynamic);
}
