package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.Kynamic;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Component
public interface KynamicMapper extends Mapper<Kynamic> {
    /**
     * 根据名称获取kynamic
     * @param name
     * @return
     */
    List<Kynamic> getKynamicByName(String name);

    /**
     * 根据id获取当前节点的兄弟节点
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
}