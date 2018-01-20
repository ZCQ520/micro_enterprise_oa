package com.wzu.oa.mapper;

import com.wzu.oa.common.entity.Kynamic;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;


@Component
public interface KynamicMapper extends Mapper<Kynamic> {
    /**
     * 获取根节点
     * @return
     */
    Kynamic getRoot();

    /**
     * 根据pid获取该文件夹下所有文件
     * @param pid
     * @return
     */
    List<Kynamic> getKynamicListByPid(Integer pid);

    /**
     * 获取当前节点下所有目录
     * @param pid
     * @return
     */
    List<Kynamic> getKynamicFolderListByPid(Integer pid);

    /**
     * 获取当前节点下所有文件
     * @param pid
     * @return
     */
    List<Kynamic> getKynamicFileListByPid(Integer pid);


    /**
     * 根据参数获取Kynamic
     * @param map
     * @return
     */
    Kynamic getKynamicByMap(Map<String, Object> map);
}