package com.wzu.oa.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wzu.oa.common.entity.Kynamic;
import com.wzu.oa.common.entity.Version;
import com.wzu.oa.common.util.BeanUtil;
import com.wzu.oa.common.util.MapUtils;
import com.wzu.oa.service.KynamicService;
import com.wzu.oa.service.VersionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2018-01-16   17:13
 */
@Controller
public class KynamicController {

    @Resource
    private KynamicService kynamicService;

    @Resource
    private VersionService versionService;


    /**
     * 获取知识管理页面
     *
     * @return
     */
    @RequestMapping("/page/LanDiskFolder/list")
    public String list() {
        return "/LanDiskFolder/list";
    }


    /**
     * json返回知识管理树数据
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/LanDiskFolder/showKynamicTree")
    public List<Kynamic> showKynamicTree() {
        List<Kynamic> allKynamic = kynamicService.getAllKynamic();
        return allKynamic;
    }


    /**
     * 检查是否有重名的现象
     *
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/LanDiskFolder/isExsitName")
    public Map<String, Object> isExsitName(String name) {
        boolean result = kynamicService.isExsitName(name);
        Map<String, Object> map = MapUtils.build().map();
        if (result) {
            //重名了
            map.put("message", "1");
        } else {
            //可以使用
            map.put("message", "2");
        }
        return map;
    }


    /**
     * 保存kynamic数据并返回id
     *
     * @param kynamic
     * @return
     */
    @ResponseBody
    @RequestMapping("/LanDiskFolder/saveKynamic")
    public Map<String, Object> saveKynamic(Kynamic kynamic) {
        Integer kid = kynamicService.saveKynamic(kynamic);
        Map<String, Object> map = MapUtils.build().put("id", kid).map();
        return map;
    }


    /**
     * 查看兄弟节点
     *
     * @param kynamic
     * @return
     */
    @ResponseBody
    @RequestMapping("/LanDiskFolder/showSiblingNodes")
    public Map<String, Object> showSiblingNodes(Kynamic kynamic) {
        Map<String, Object> map = MapUtils.build().put("kynamicList", kynamicService.getSiblingNodes(kynamic.getId())).map();
        return map;
    }


    /**
     * 查看父节点
     * @param kynamic
     * @return
     */
    @ResponseBody
    @RequestMapping("/LanDiskFolder/showParentNode")
    public Map<String, Object> showParentNode(Kynamic kynamic) {
        Kynamic parentNode = kynamicService.getParentNode(kynamic.getId());
        Map<String, Object> map = MapUtils.build().put("kynamic",parentNode).map();
        return map;
    }


    /**
     * 删除节点
     * @param kynamic
     * @return
     */
    @ResponseBody
    @RequestMapping("/LanDiskFolder/deleteNode")
    public Map<String, Object> deleteNode(Kynamic kynamic) {
        kynamicService.deleteKynamicById(kynamic.getId());
        Map<String, Object> map = MapUtils.build().put("message", "操作成功").map();
        return map;
    }



    /**
     * 删除节点
     * @param kynamic
     * @return
     */
    @ResponseBody
    @RequestMapping("/LanDiskFolder/updateKynamic")
    public Map<String, Object> updateKynamic(Kynamic kynamic) {
        kynamicService.updateKynamic(kynamic.getId(),kynamic.getName());
        Map<String, Object> map = MapUtils.build().put("message", "操作成功").map();
        return map;
    }

    //TODO spring mvc转换json数据时date类型会被转换为时间戳，解决方法：在date属性上加@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    /**
     * 根据文件id查看所有版本
     * @param kynamic
     * @return
     */
    @ResponseBody
    @RequestMapping("/LanDiskFolder/showVersionsById")
    public Map<String, Object> showVersionsById(Kynamic kynamic) {
        List<Version> versionList = versionService.getVersionsByKid(kynamic.getId());
        Map<String, Object> map = MapUtils.build().put("versionList", versionList).map();
        return map;
    }
}
