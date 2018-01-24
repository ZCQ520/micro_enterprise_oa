package com.wzu.oa.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jack
 * @date 2018-01-24   20:03
 */
@Controller
public class ToolController {


    /**
     * 跳转火车票网
     * @return
     */
    @RequiresPermissions("车票预定")
    @RequestMapping("/tool/trainTicket")
    public String trainTicket(){
        return "redirect:http://www.12306.cn";
    }


    /**
     * 跳转飞机票网
     * @return
     */
    @RequiresPermissions("飞机航班")
    @RequestMapping("/tool/planeTicket")
    public String planeTicket(){
        return "redirect:http://www.airchina.com.cn";
    }


    /**
     * 跳转邮编查询网
     * @return
     */
    @RequiresPermissions("邮政编码")
    @RequestMapping("/tool/postCode")
    public String postCode(){
        return "redirect:http://www.yb21.cn/";
    }






}
