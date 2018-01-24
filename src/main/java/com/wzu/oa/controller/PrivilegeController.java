package com.wzu.oa.controller;

import com.wzu.oa.common.entity.UserResource;
import com.wzu.oa.common.util.MapUtils;
import com.wzu.oa.common.util.PrivilegeUtils;
import com.wzu.oa.service.UserResourceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @date 2018-01-24   15:53
 */
@Controller
public class PrivilegeController {

    @Resource
    private UserResourceService userResourceService;

    @ResponseBody
    @RequestMapping("/privilege/savePrivilege")
    public Map<String, Object> savePrivilege(Integer uid, Integer[] mids){
        Map<String, Object> map = MapUtils.build().map();
        List<UserResource> userResource = PrivilegeUtils.getUserResource(uid, mids);
        try {
            userResourceService.savePrivilege(uid,userResource);
            map.put("msg","更新权限成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg","更新权限失败");
            return map;
        }
        return map;
    }

}
