package com.wzu.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jack
 * @date 2017/10/26   14:45
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/page/{page}")
    public String toPage(@PathVariable("page") String page){
        return page;
    }

    @RequestMapping("/System_User/{page}")
    public String toSystemUserPage(@PathVariable("page") String page){
        return "/System_User/"+page;
    }
}
