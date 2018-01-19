package com.wzu.oa.service.impl;

import com.wzu.oa.common.entity.Kynamic;
import com.wzu.oa.mapper.KynamicMapper;
import com.wzu.oa.service.KynamicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    public boolean isExsitName(String name) {
        List<Kynamic> list = kynamicMapper.getKynamicByName(name);
        if (list == null || list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void deleteKynamicById(Integer id) {
        kynamicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Kynamic> getSiblingNodes(Integer id) {
        return kynamicMapper.getSiblingNodes(id);
    }

    @Override
    public Kynamic getParentNode(Integer id) {
        return kynamicMapper.getParentNode(id);
    }

    @Override
    public void updateKynamic(Integer id, String name) {
        Kynamic kynamic = kynamicMapper.selectByPrimaryKey(id);
        kynamic.setName(name);
        kynamicMapper.updateByPrimaryKey(kynamic);
    }


}
