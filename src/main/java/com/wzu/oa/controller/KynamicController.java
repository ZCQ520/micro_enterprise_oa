package com.wzu.oa.controller;

import com.wzu.oa.service.KynamicService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author jack
 * @date 2018-01-16   17:13
 */
@Controller
public class KynamicController {

    @Resource
    private KynamicService kynamicService;


}
