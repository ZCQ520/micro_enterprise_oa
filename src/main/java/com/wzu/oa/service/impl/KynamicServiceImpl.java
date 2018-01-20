package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.DTO.KynamicDTO;
import com.wzu.oa.common.entity.Kynamic;
import com.wzu.oa.common.util.MapUtils;
import com.wzu.oa.mapper.KynamicMapper;
import com.wzu.oa.service.KynamicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2018-01-16   17:11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class KynamicServiceImpl implements KynamicService {

    @Resource
    private KynamicMapper kynamicMapper;

    @Override
    public List<Kynamic> getAllKynamic() {
        return kynamicMapper.selectAll();
    }

    @Override
    public Integer saveKynamic(Kynamic kynamic) {
        kynamicMapper.insert(kynamic);
        return kynamic.getId();
    }



    @Override
    public boolean deleteKynamicById(Integer id) {
        Kynamic kynamic = kynamicMapper.selectByPrimaryKey(id);
        if (kynamic!=null){
            if (!kynamic.getIsParent()){
                String docFilePath = kynamic.getDocFilePath();
                if (docFilePath!=null){
                    File file = new File(docFilePath);
                    if (file.exists()){
                        file.delete();
                    }
                }
            }else {
                List<Kynamic> kynamicListByPid = kynamicMapper.getKynamicListByPid(id);
                if (kynamicListByPid.size()>0) {
                    return false;
                }
            }
            kynamicMapper.deleteByPrimaryKey(id);
            return true;
        }
        return false;

    }



    @Override
    public void updateKynamic(Integer id, String name) {
        Kynamic kynamic = kynamicMapper.selectByPrimaryKey(id);
        kynamic.setName(name);
        kynamicMapper.updateByPrimaryKey(kynamic);
    }

    @Override
    public List<KynamicDTO> getRootKynamicList() {
        List<Kynamic> kynamicList = new ArrayList<>();
        Kynamic rootKynamic = kynamicMapper.getRoot();
        if (rootKynamic!=null){
            //获取当前节点下所有目录
            List<Kynamic> folderKynamicList = kynamicMapper.getKynamicFolderListByPid(rootKynamic.getId());
            //获取当前目录下所有文件
            List<Kynamic> fileKynamicList = kynamicMapper.getKynamicFileListByPid(rootKynamic.getId());
            //合并两个列表
            folderKynamicList.addAll(fileKynamicList);
            kynamicList = folderKynamicList;
        }
        return getKynamicDTOList(kynamicList);
    }

    @Override
    public List<KynamicDTO> getCurrentNodeList(Integer pid) {
        if (pid==null)
            return getRootKynamicList();
        //获取当前节点下所有目录
        List<Kynamic> folderKynamicList = kynamicMapper.getKynamicFolderListByPid(pid);
        //获取当前目录下所有文件
        List<Kynamic> fileKynamicList = kynamicMapper.getKynamicFileListByPid(pid);
        //合并两个列表
        folderKynamicList.addAll(fileKynamicList);
        return getKynamicDTOList(folderKynamicList);
    }

    @Override
    public String getCurrentPathById(Integer id) {
        if (id==null){
            Kynamic root = kynamicMapper.getRoot();
            return "/"+root.getName();
        }
        Kynamic kynamic = kynamicMapper.selectByPrimaryKey(id);
        String path = "/"+kynamic.getName();
        while (kynamic.getPid()!=null){
            kynamic = kynamicMapper.selectByPrimaryKey(kynamic.getPid());
            path = "/"+kynamic.getName()+path;
        }
        return path;
    }

    @Override
    public Kynamic getKynamicById(Integer id) {
        return kynamicMapper.selectByPrimaryKey(id);
    }

    @Override
    public Kynamic getRootKynamic() {
        return kynamicMapper.getRoot();
    }

    @Override
    public void addOrUpdateKynamic(Kynamic kynamic) {
        Integer id = kynamic.getId();
        if (id==null) {
            kynamicMapper.insert(kynamic);
        }else {
            Kynamic oldKynamic = kynamicMapper.selectByPrimaryKey(id);
            oldKynamic.setName(kynamic.getName());
            oldKynamic.setDescription(kynamic.getDescription());
            kynamicMapper.updateByPrimaryKey(oldKynamic);
        }
    }

    @Override
    public void updateFileKynamic(Kynamic kynamic) {
        Kynamic oldKynamic = kynamicMapper.selectByPrimaryKey(kynamic.getId());
        oldKynamic.setDescription(kynamic.getDescription());
        kynamicMapper.updateByPrimaryKey(oldKynamic);
    }

    @Override
    public boolean updateKynamicName(Kynamic kynamic) {
        Map<String, Object> map = MapUtils.build().put("isParent", kynamic.getIsParent()).put("name", kynamic.getName()).map();
        Kynamic existKynamic = kynamicMapper.getKynamicByMap(map);
        if (existKynamic!=null)
            return false;
        Kynamic oldKynamic = kynamicMapper.selectByPrimaryKey(kynamic.getId());
        oldKynamic.setName(kynamic.getName());
        kynamicMapper.updateByPrimaryKey(oldKynamic);
        return true;
    }


    /**
     * 根据kynamicList包装kynamicDTOlist
     * @param kynamicList
     * @return
     */
    private List<KynamicDTO> getKynamicDTOList(List<Kynamic> kynamicList){
        List<KynamicDTO> kynamicDTOList = new ArrayList<>();
        for (Kynamic kynamic : kynamicList) {
            Boolean isFloder = kynamic.getIsParent();
            KynamicDTO kynamicDTO = null;
            if (isFloder) {
                kynamicDTO = new KynamicDTO(kynamic,"folder.gif" );
                kynamicDTOList.add(kynamicDTO);
            }else {
                String name = kynamic.getName();
                String[] strings = name.split("\\.");
                String suffix = "";
                if (strings.length>1) {
                    suffix = strings[strings.length - 1];
                }
                kynamicDTO = new KynamicDTO(kynamic,suffix+".gif" );
                kynamicDTOList.add(kynamicDTO);
            }
        }
        return kynamicDTOList;
    }

}
